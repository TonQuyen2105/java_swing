/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package script;

/**
 *
 * @author TonQuyen
 */
public class userSession {
    public static boolean isLoggedIn = false;
    public static int userID = -1;
    public static void setID(int id)
    {
        userID = id;
    }
    public static int getUserID(){
        return userID;
    }
}
