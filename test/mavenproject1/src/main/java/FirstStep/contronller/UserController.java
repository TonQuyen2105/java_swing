/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FirstStep.contronller;

import FirstStep.model.Entity.Users;
import FirstStep.model.DAO.UsersDAO;
import java.util.List;


/**
 *
 * @author acebi
 */
public class UserController {
    private final UsersDAO usersDAO = new UsersDAO();
    
    public List<Users> getUsers() {
        return usersDAO.getAll();
    }

    public String formatUsers(List<Users> users) {
        StringBuilder sb = new StringBuilder();

        // Độ rộng cột được chọn hợp lý
        int idWidth = 4;
        int usernameWidth = 20;
        int passwordWidth = 15;
        int roleWidth = 10;

        // Header
        sb.append(String.format("%-" + idWidth + "s | %-" + usernameWidth + "s | %-" +
                passwordWidth + "s | %-" + roleWidth + "s%n",
                "ID", "USERNAME", "PASSWORD", "ROLE"));

        // Dòng gạch ngang chia bảng (độ dài khớp với tổng chiều rộng thật)
        sb.append("-".repeat(idWidth + usernameWidth + passwordWidth + roleWidth + 9));
        sb.append("\n");

        // Dữ liệu
        for (Users u : users) {
            sb.append(String.format("%-" + idWidth + "d | %-" + usernameWidth + "s | %-" +
                    passwordWidth + "s | %-" + roleWidth + "s%n",
                    u.getId(), u.getUsername(), u.getPassword(), u.getRole()));
        }

        return sb.toString();
    }
}
