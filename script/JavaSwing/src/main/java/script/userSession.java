
package script;

public class userSession {
    public static String userID = "";
    public static void setUserID(String id)
    {
        userID = id;
    }
    public static String getUserID(){
        return userID;
    }
}
