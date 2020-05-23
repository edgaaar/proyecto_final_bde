package com.geounam;

import java.io.IOException;

import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class PointToJsonSerializer extends JsonSerializer<Point> {

    @Override
    public void serialize(Point value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {

        String jsonValue = "null";
        try
        {
            if(value != null) {             

                GeometryJSON geomJson = new GeometryJSON();
                jsonValue = geomJson.toString(value);

            }
        }
        catch(Exception e) {}

        jgen.writeRawValue(jsonValue);
    }

}