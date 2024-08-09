package com.example.spring_source.demo.设计模式.创建者模式.原型模式;

import java.io.*;

/**

所有使用改工具的类必须实现Serializable接口生成
    例：
	@Serial
    private static final long serialVersionUID = -5461562539764872674L;
*/

public class DeepCloneUtil {

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepClone(T object) {
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(object);
            out.flush();
            out.close();

            // Read a new object from the byte array
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
