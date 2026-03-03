package api.utils;

public class Utils {

    public static String htmlToJson(String response){
        String cleanJson = response
                .replaceAll("<[^>]*>", "")
                .trim();
        return cleanJson;
    }
}
