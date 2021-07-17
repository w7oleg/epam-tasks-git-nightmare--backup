package collections.flowergirl.creationobjects.helperclasses;

import java.util.Locale;
import java.util.ResourceBundle;


public class ResourceBundleManager {
    public static ResourceBundle getResourceBundle() {
        Locale.setDefault(new Locale("ru", "BY"));
        return ResourceBundle.getBundle("message");
    }
}
