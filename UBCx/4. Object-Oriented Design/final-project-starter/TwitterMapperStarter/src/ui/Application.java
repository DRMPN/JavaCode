package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;
import query.Query;
import twitter.LiveTwitterSource;
import twitter.TwitterSource;
import util.SphericalGeometry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;
import java.util.Timer;

/**
 * The Twitter viewer application
 * Derived from a JMapViewer demo program written by Jan Peter Stotz
 */
public class Application extends JFrame {
    // The content panel, which contains the entire UI
    private final ContentPanel contentPanel;
    // The provider of the tiles for the map, we use the Bing source
    private BingAerialTileSource bing;
    // All of the active queries
    private List<Query> queries = new ArrayList<>();
    // The source of tweets, a TwitterSource, either live or playback
    private TwitterSource twitterSource;

    private void initialize() {
        // To use the live twitter stream, use the following line
        // twitterSource = new LiveTwitterSource();

        // To use the recorded twitter stream, use the following line
        // The number passed to the constructor is a speedup value:
        //  1.0 - play back at the recorded speed
        //  2.0 - play back twice as fast

        //twitterSource = new PlaybackTwitterSource(60.0);
        //doesnt work
        twitterSource = new LiveTwitterSource();

        queries = new ArrayList<>();
    }

    /**
     * A new query has been entered via the User Interface
     * @param   query   The new query object
     */
    public void addQuery(Query query) {
        queries.add(query);
        Set<String> allterms = getQueryTerms();
        twitterSource.setFilterTerms(allterms);
        contentPanel.addQuery(query);
        // TODO - Completed: This is the place where you should connect the new query to the twitter source
        twitterSource.addObserver(query);
    }

    /**
     * return a list of all terms mentioned in all queries. The live twitter source uses this
     * to request matching tweets from the Twitter API.
     * @return
     */
    private Set<String> getQueryTerms() {
        Set<String> ans = new HashSet<>();
        for (Query q : queries) {
            ans.addAll(q.getFilter().terms());
        }
        return ans;
    }

    /**
     * Constructs the {@code Application}.
     */
    public Application() {
        super("Twitter content viewer");
        setSize(300, 300);
        initialize();

        bing = new BingAerialTileSource();

        // Do UI initialization
        contentPanel = new ContentPanel(this);
        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Always have map markers showing.
        map().setMapMarkerVisible(true);
        // Always have zoom controls showing,
        // and allow scrolling of the map around the edge of the world.
        map().setZoomContolsVisible(true);
        map().setScrollWrapEnabled(true);

        // Use the Bing tile provider
        map().setTileSource(bing);

        //NOTE This is so that the map eventually loads the tiles once Bing attribution is ready.
        Coordinate coord = new Coordinate(0, 0);

        Timer bingTimer = new Timer();
        TimerTask bingAttributionCheck = new TimerTask() {
            @Override
            public void run() {
                // This is the best method we've found to determine when the Bing data has been loaded.
                // We use this to trigger zooming the map so that the entire world is visible.
                if (!bing.getAttributionText(0, coord, coord).equals("Error loading Bing attribution data")) {
                    map().setZoom(2);
                    bingTimer.cancel();
                }
            }
        };
        bingTimer.schedule(bingAttributionCheck, 100, 200);

        // Set up a motion listener to create a tooltip showing the tweets at the pointer position
        map().addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                placeTweetToolTip(p);
            }
        });
    }

    // MODIFIES: map()
    // EFFECTS: If mouse cursor is on a tweet marker
    //             then creates a tooltip with text and image of user profile
    //             else does not create a tooltip
/*

    private void placeTweetToolTip(Point p) {

        ICoordinate pos = map().getPosition(p);
        List<MapMarker> markerList = getMarkersCovering(pos, pixelWidth(p));

        if (!markerList.isEmpty()) {
            PrettyMapMarker singleMarker = (PrettyMapMarker) markerList.get(0);

            // https://twitter.com/i/user/id
            long statusName = singleMarker.getStatus().getUser().getId();
            String statusImage = singleMarker.getStatus().getUser().getBiggerProfileImageURL();
            String statusText = singleMarker.getStatus().getText();

            map().setToolTipText(
                    "<html>\n" +
                            "<table width='100%' height='100%' cellspacing='5' cellpadding='0'>\n" +
                            "  <tr>\n" +
                            "    <td align='center'>" +
                            "</td><td>User ID:"+statusName+"</td>\n" +
                            "  </tr>\n" +
                            "  \n" +
                            "  <tr>\n" +
                            "    <td><img src=" + statusImage + "></td>\n" +
                            "    <td width='210'>"+statusText+"</td> \n" +
                            "  </tr>\n" +
                            "\n" +
                            "</table>\n" +
                            "</html>"
            );

        }
        else { map().setToolTipText(null); }
    }
*/

    private void placeTweetToolTip(Point p) {

        ICoordinate pos = map().getPosition(p);
        List<MapMarker> markerList = getMarkersCovering(pos, pixelWidth(p));
        StringBuilder tweetInfo = new StringBuilder("<html>\n");

        if (!markerList.isEmpty()) {

            for (MapMarker mapMarker : markerList) {
                PrettyMapMarker singleMarker = (PrettyMapMarker) mapMarker;
                tweetInfo.append(createHTMLTable(singleMarker));
            }

            tweetInfo.append("</html>");
            map().setToolTipText(tweetInfo.toString());
        }

        else { map().setToolTipText(null); }
    }

    private String createHTMLTable(PrettyMapMarker pmMarker) {

        long statusName = pmMarker.getStatus().getUser().getId();
        String statusImage = pmMarker.getStatus().getUser().getBiggerProfileImageURL();
        String statusText = pmMarker.getStatus().getText();

        return "<table width='100%' height='100%' cellspacing='5' cellpadding='0'>\n" +
                        "  <tr>\n" +
                        "    <td align='center'>" +
                        "</td><td>User ID:"+statusName+"</td>\n" +
                        "  </tr>\n" +
                        "  \n" +
                        "  <tr>\n" +
                        "    <td><img src=" + statusImage + "></td>\n" +
                        "    <td width='210'>"+statusText+"</td> \n" +
                        "  </tr>\n" +
                        "\n" +
                        "</table>\n";
    }

    // How big is a single pixel on the map?  We use this to compute which tweet markers
    // are at the current most position.
    private double pixelWidth(Point p) {
        ICoordinate center = map().getPosition(p);
        ICoordinate edge = map().getPosition(new Point(p.x + 1, p.y));
        return SphericalGeometry.distanceBetween(center, edge);
    }

    // Get those layers (of tweet markers) that are visible because their corresponding query is enabled
    private Set<Layer> getVisibleLayers() {
        Set<Layer> ans = new HashSet<>();
        for (Query q : queries) {
            if (q.getVisible()) {
                ans.add(q.getLayer());
            }
        }
        return ans;
    }

    // Get all the markers at the given map position, at the current map zoom setting
    private List<MapMarker> getMarkersCovering(ICoordinate pos, double pixelWidth) {
        List<MapMarker> ans = new ArrayList<>();
        Set<Layer> visibleLayers = getVisibleLayers();
        for (MapMarker m : map().getMapMarkerList()) {
            if (!visibleLayers.contains(m.getLayer())) continue;
            double distance = SphericalGeometry.distanceBetween(m.getCoordinate(), pos);
            if (distance < m.getRadius() * pixelWidth) {
                ans.add(m);
            }
        }
        return ans;
    }

    public JMapViewer map() {
        return contentPanel.getViewer();
    }

    /**
     * @param args Application program arguments (which are ignored)
     */
    public static void main(String[] args) {
        new Application().setVisible(true);
    }

    // Update which queries are visible after any checkBox has been changed
    public void updateVisibility() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Recomputing visible queries");
                for (Query q : queries) {
                    JCheckBox box = q.getCheckBox();
                    Boolean state = box.isSelected();
                    q.setVisible(state);
                }
                map().repaint();
            }
        });
    }

    // A query has been deleted, remove all traces of it
    public void terminateQuery(Query query) {
        // TODO: This is the place where you should disconnect the expiring query from the twitter source
        twitterSource.deleteObserver(query);
        System.out.println(" *** Query is deleted *** ");
        queries.remove(query);
        Set<String> allterms = getQueryTerms();
        twitterSource.setFilterTerms(allterms);
    }
}

// Util for creating toolTip
/*            map().setToolTipText(
                    "<html>"
                    +"<table width='100%' height='100%' cellspacing='5' cellpadding='0'>"
                    +"<tr>"
                    +"<td class='leftcol'>"
                    +"<img src="+statusImage+">"
                    +"</td>"
                    +"<td valign='top' width='210'>"+statusText
                    +"</td>"
                    +"</tr>"
                    +"</table>"
                    +"</html>");
            */