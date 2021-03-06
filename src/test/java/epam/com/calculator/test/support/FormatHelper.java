package epam.com.calculator.test.support;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FormatHelper {
    private static final Logger LOG = LogManager.getLogger(FormatHelper.class);

    public static double convertStringDouble(String var) {
        try{
            return Double.parseDouble(var);
        } catch (NumberFormatException e) {
            LOG.error("NumberFormatException for input string.");
        }
        return Double.parseDouble(var);
    }

    public static long convertStringLong(String var) {
        try{
            return Long.parseLong(var);
        } catch (NumberFormatException e) {
            LOG.error("NumberFormatException for input string.");
        }
        return Long.parseLong(var);
    }

    public static double round(double value) {
        return (double)Math.round(value * 100d) / 100d;
    }
}
