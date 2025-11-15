
package script;

public class userSession {
    public static int userID = -1;
    public static void setUserID(int id)
    {
        userID = id;
    }
    public static int getUserID(){
        return userID;
    }
}
