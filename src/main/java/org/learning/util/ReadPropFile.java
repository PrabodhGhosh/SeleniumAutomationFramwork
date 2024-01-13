package org.learning.util;

import org.learning.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropFile {
    private ReadPropFile() {
    }

    private static Properties prop = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilepath());
            prop.load(fis);
            for(Map.Entry<Object,Object> entry: prop.entrySet() )
            {
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String readProp(String key) throws FileNotFoundException {

        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            throw new FileNotFoundException("Property name not found");
        }
        return prop.getProperty(key);

    }

}
