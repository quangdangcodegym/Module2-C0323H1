package com.codegym.view;

import com.codegym.config.Config;
import com.codegym.model.Customer;
import com.codegym.model.ERole;
import com.codegym.model.Egender;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.codegym.service.UserService;
import com.codegym.utils.DateUtils;
import com.codegym.utils.ValidateUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class UserView {
    private Scanner scanner = new Scanner(System.in);
    private static final int INPUT_USER_ADD = 1;
    private static final int INPUT_USER_EDIT = 2;



    private IUserService iuserService;
    private List<User> users;

    public UserView() {
        iuserService = new UserService();
    }

    public void launcher() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;

            System.out.println("=================================================");
            System.out.println("|| Chào mừng bạn đến với Menu Quản lý USER     ||");
            System.out.println("|| ------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ danh sách các USER      ||");
            System.out.println("|| Nhấn 2: Thêm USER mới                       ||");
            System.out.println("|| Nhấn 3: Sửa thông tin của USER hiện tại     ||");
            System.out.println("|| Nhấn 4: Xóa USER hiện tại                   ||");
            System.out.println("|| Nhấn 5: Sắp xếp USER theo tên               ||");
            System.out.println("|| Nhấn 6: Sắp xếp USER theo ngay thang        ||");
            System.out.println("|| Nhấn 7: Tìm kiem USER theo ngay ten         ||");
            System.out.println("|| Nhấn 8: Tim kiem USER theo nam sinh         ||");
            System.out.println("|| Nhấn 9: Tim kiem USER theo khoản time       ||");
            System.out.println("=================================================");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showUser(iuserService.getAllUsers());
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    editUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    sortUserByNameView();
                    break;
                case 6:
                    sortUserByDateView();
                    break;
                case 7:
                    searchUserByNameView();
                    break;
                case 8:
                    searchUserByYearView();
                    break;
                case 9:
                    searchUserByRangeDateView();
                    break;
                default:
                    System.out.println("Nhập không đúng, vui lòng nhập lại!");
                    continue;
            }

            boolean repeatMenu;
            do {
                repeatMenu = true;
                System.out.println("Ban có muốn tiếp tục hay không: ");
                System.out.println("Nhập 1. Tiếp tục");
                System.out.println("Nhập 2. Kết thúc");

                int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                switch (actionMenuContinue) {
                    case 1:
                        checkActionMenu = true;
                        repeatMenu = false;
                        break;
                    case 2:
                        checkActionMenu = false;
                        repeatMenu = false;
                        break;
                    default:
                        System.out.println("Không đúng lệnh, vui lòng nhập lại:");
                }
            } while (repeatMenu);
        } while (checkActionMenu);
    }

    private void searchUserByRangeDateView() {
        System.out.println("Nhập thoi gian bat dau: (dd-MM-yyyy)");
        LocalDate d1 = DateUtils.parseStrLocalDate(scanner.nextLine());

        System.out.println("Nhập thoi gian ket thuc: (dd-MM-yyyy)");
        LocalDate d2 = DateUtils.parseStrLocalDate(scanner.nextLine());

        List<User> userSearched = iuserService.searchUserByRangeDate(d1, d2);

        showUser(userSearched);
    }

    private void searchUserByYearView() {
        System.out.println("Nhập năm: ");
        int year = Integer.parseInt(scanner.nextLine());

        List<User> userSearched = iuserService.searchUserByYear(year);
        showUser(userSearched);
    }

    private void searchUserByNameView() {
        System.out.println("Nhập tên cần tìm: ");
        String key = scanner.nextLine();
        List<User> usersSearched = iuserService.searchUserByName(key);

        showUser(usersSearched);
    }

    private void sortUserByDateView() {
        List<User> users = iuserService.getAllUsers();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getDob().compareTo(o2.getDob());
            }
        });
        showUser(users);
    }

    private void sortUserByNameView() {
        List<User> users = iuserService.getAllUsers();
        // Viet theo kieu anonymous class
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        showUser(users);
    }

    private void showUser(List<User> users) {
        System.out.printf("%-5s | %-20s | %-25s | %-15s | %-15s | %-15s\n",
                "ID", "NAME", "ADDRESS", "GENDER", "ROLE", "DoB");
        for (int i = 0; i < users.size(); i++) {
            User item = users.get(i);
            String dateView = DateUtils.formatLocalDate(item.getDob());
            String result = dateView == null ? "" : dateView;

            System.out.printf("%-5s | %-20s | %-25s | %-15s | %-15s | %-15s\n",
                    item.getId(), item.getName(), item.getAddress(), item.getEgender(), item.getErole(), result);
        }
    }

    private void addUser() {
        User user = new User();
        user.setId(System.currentTimeMillis() % 1000);
        inputUser(INPUT_USER_ADD, user);
        iuserService.addUser(user);
        showUser(iuserService.getAllUsers());
    }

    public void inputNameUSER(String strACTION,int ACTION, User user){
        if(ACTION == INPUT_USER_ADD){
            do {
                System.out.printf("Nhập tên %s của user \n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidName(name, Config.REGEX_CUSTOMER)) {
                    System.out.println("Tên không hợp lệ. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                }else{
                    user.setName(name);
                    break;
                }
            } while (true);
        }else {
            do {
                System.out.printf("Nhập tên %s của user Enter để bỏ qua\n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidName(name, Config.REGEX_CUSTOMER)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Tên không hợp lệ. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                }else {
                    user.setName(name);
                    break;
                }
            } while (true);
        }
    }
    private void inputUser(int ACTION, User user) {
        String strACTION = ACTION == INPUT_USER_ADD ? "" : "cần sửa lại";

        inputNameUSER(strACTION, INPUT_USER_ADD, user);

        System.out.printf("Nhập địa chỉ của USER %s: \n", strACTION);
        String address = scanner.nextLine();

        System.out.println("Chọn giới tính (Gender): ");
        for (Egender e : Egender.values()) {
            if (e.equals(user.getEgender())) {
                continue;
            }
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        int actionMenuUser1 = Integer.parseInt(scanner.nextLine());
        user.setEgender(Egender.findById(actionMenuUser1));

        System.out.println("Chọn vai trò (Role): ");
        for (ERole r : ERole.values()) {
            if (r.equals(user.getErole())) {
                continue;
            }
            System.out.println("Nhập " + r.getId() + "." + r.getName());
        }
        int actionMenuUser = Integer.parseInt(scanner.nextLine());
        user.setErole(ERole.findById(actionMenuUser));

        inputDobUser(strACTION, INPUT_USER_ADD, user);

        user.setAddress(address);

    }

    private void inputDobUser(String strACTION, int inputUserAdd, User user) {
        do {
            System.out.printf("Nhập ngày sinh %s của user Enter để bỏ qua\n", strACTION);
            System.out.println("Nhập ngày sinh (dd-MM-yyyy): ");
            String dobString = scanner.nextLine();
            LocalDate lDob = null;
            try {
                lDob = DateUtils.parseStrLocalDate(dobString);
                if (lDob != null) {
                    user.setDob(lDob);
                    break;
                }
            } catch (DateTimeParseException dateTimeParseException) {
                if (dobString.equals("")) {
                    break;
                }
            }
        } while (true);
    }

    private void editUser() {
        showUser(iuserService.getAllUsers());
        System.out.println("Nhập ID của USER cần sửa: ");
        long idUserEdit = Long.parseLong(scanner.nextLine());

        User userEdit = iuserService.findUserById(idUserEdit);
        if (userEdit != null) {
            inputUser(INPUT_USER_EDIT, userEdit);
            iuserService.updateUserById(idUserEdit, userEdit);
        } else {
            System.out.println("USER này không tồn tại!");
        }
        showUser(iuserService.getAllUsers());
    }

    private void deleteUser() {
        boolean continueDeleting = true;
        do {
            showUser(iuserService.getAllUsers());
            System.out.println("Nhập ID của USER cần xóa: ");
            long idUserDelete = Long.parseLong(scanner.nextLine());

            if (idUserDelete == 0) {
                continueDeleting = false; // Người dùng nhập 0, thoát khỏi vòng lặp
            } else {
                User userDelete = iuserService.findUserById(idUserDelete);

                if (userDelete == null) {
                    System.out.println("ID bài báo này không tồn tại!");
                } else {
                    iuserService.deleteUserById(idUserDelete);
                }
            }
        } while (continueDeleting);
    }

    public static void main(String[] args) {
        UserView userView = new UserView();
        userView.launcher();
    }
}