package com.fasterxml.jackson.datatype.jsr353;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;

import javax.json.Json;
import javax.json.JsonMergePatch;
import java.io.IOException;

public class JsonMergePatchDeserializer extends StdDeserializer<JsonMergePatch> {

    protected final JsonValueDeserializer jsonValueDeser;

    public JsonMergePatchDeserializer(JsonValueDeserializer jsonValueDeser) {
        super(JsonMergePatch.class);
        this.jsonValueDeser = jsonValueDeser;
    }

    @Override
    public LogicalType logicalType() {
        return jsonValueDeser.logicalType();
    }
    
    @Override
    public JsonMergePatch deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return Json.createMergePatch(jsonValueDeser.deserialize(p, ctxt));
    }

}
