package liashenko.airline.persistence.utils;

import liashenko.airline.persistence.exceptions.ReadWriteException;
import org.apache.log4j.Logger;

import java.io.*;

public abstract class DataReadWriteUtils {
    public static final String STORAGE_DIR = "storage";
    private static final Logger logger = Logger.getLogger(DataReadWriteUtils.class);

    private static void createStorageDirIfNotExist() {
        File file = new File(STORAGE_DIR);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
    }

    public static boolean write(Object object, String path) {
        createStorageDirIfNotExist();
        try (FileOutputStream out = new FileOutputStream(path)) {
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream dout = new ObjectOutputStream(bout);
            dout.writeObject(object);
            dout.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new ReadWriteException(e.getMessage());
        }
        return true;
    }

    public static Object read(String path) {
        createStorageDirIfNotExist();
        try (FileInputStream out = new FileInputStream(path)) {
            BufferedInputStream bout = new BufferedInputStream(out);
            ObjectInputStream dout = new ObjectInputStream(bout);
            return dout.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e.getMessage());
            throw new ReadWriteException(e.getMessage());
        }
    }
}
