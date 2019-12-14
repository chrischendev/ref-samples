package com.aiways.storm.utils;

import org.apache.storm.spout.Scheme;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.List;

public class MessageScheme implements Scheme {
    
    /* (non-Javadoc)
     * @see backtype.storm.spout.Scheme#deserialize(byte[])
     */
    public List<Object> deserialize(byte[] ser) {
        try {
            String msg = new String(ser, "UTF-8"); 
            return new Values(msg);
        } catch (UnsupportedEncodingException e) {
         
        }
        return null;
    }


    @Override
    public List<Object> deserialize(ByteBuffer ser) {
        return null;
    }

    /* (non-Javadoc)
     * @see backtype.storm.spout.Scheme#getOutputFields()
     */
    public Fields getOutputFields() {
        // TODO Auto-generated method stub
        return new Fields("msg");  
    }  
}