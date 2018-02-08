package com.tx.saveWorld.common.utils;

import java.io.*;

public class ByteUtils {
	
	public static byte[] object2Byte (Object obj) {        
        byte[] bytes = null;        
        ByteArrayOutputStream bos = null; 
        ObjectOutputStream oos = null;
        try {          
        	bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);           
            oos.writeObject(obj);          
            oos.flush();           
            bytes = bos.toByteArray ();        
            oos.close();           
            bos.close();          
        } catch (IOException ex) {
        	
        }finally {
            closeOutIo(bos,oos);
        }
        return bytes;      
    }     
         
        
    public static Object byte2Object (byte[] bytes) {        
        Object obj = null;      
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {          
            bis = new ByteArrayInputStream (bytes);          
            ois = new ObjectInputStream (bis);          
            obj = ois.readObject();           
        } 
        catch(Exception e){
        	
        }
        finally {
            closeInputIo(bis,ois);
		}   
        return obj;      
    }

    private static void closeInputIo(ByteArrayInputStream bis,ObjectInputStream ois){
        try {
            if (bis != null) {
                bis.close();
            }
            if (ois != null) {
                ois.close();
            }
        } catch (IOException e) {

        }
    }

    private static void closeOutIo(ByteArrayOutputStream bos,ObjectOutputStream oos){
        try {
            if (bos != null) {
                bos.close();
            }
            if (oos != null) {
                oos.close();
            }
        } catch (IOException e) {

        }
    }
}
