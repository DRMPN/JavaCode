package ui;

import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import query.Query;
import twitter4j.Status;
import util.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class PrettyMapMarker extends MapMarkerCircle {

    public static final double defaultMarkerSize = 5.0;
    public final Status status;
    public final Query query;


    public PrettyMapMarker(Query query, Status status) {
        super(query.getLayer(), null, Util.statusCoordinate(status), defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(query.getColor());

        this.query = query;
        this.status = status;
    }


    // getters
    public Query getQuery() {
        return query;
    }
    public Status getStatus() {
        return status;
    }

}
