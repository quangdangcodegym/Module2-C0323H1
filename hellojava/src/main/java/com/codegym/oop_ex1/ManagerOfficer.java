package com.codegym.oop_ex1;

import java.util.Arrays;
import java.util.Scanner;

public class ManagerOfficer {
    public Scanner scanner = new Scanner(System.in);
    private Officer [] officers;

    public ManagerOfficer() {
        officers = new Officer[5];
        //Worker String name, int age, String gender, String address, int level
        officers[0] = new Worker(1,"Đạt", 20, "Nam", "28 NTP", 9);
        //Engineer(String name, int age, String gender, String address, String branch)
        officers[1] = new Engineer(2, "Bảo", 19, "Nam", "28 NTP", "Bằng ĐH Bách Khoa");
//        Staff(String name, int age, String gender, String address, String task)
        officers[2] = new Staff(3,"Nhân", 30, "Nam", "29 NTP", "Vẫy vẫy");
        officers[3] = new Worker(4, "Hiếu", 29, "Nam", "28 NTP", 0);
        officers[4] = new Worker(5, "Minh", 25, "Nam", "28 NTP", 9);

//        addOfficerView();
        editOfficeView();



        showOffices(officers);
    }

    private void addOfficerView() {
        System.out.println("Thêm mới cán bộ: ");
        System.out.println("Bạn muốn thêm can bộ loại nào: ");
        System.out.println("Nhập 1. Worker");
        System.out.println("Nhập 2. Engineer");
        System.out.println("Nhập 3. Staff");
        int actionMenu = Integer.parseInt(scanner.nextLine());
        String address = null;
        String gender = null;
        String name = null;
        Officer officer = null;
        int age = 0;
        switch (actionMenu) {
            case 1:
                officer = new Worker();
                inputBasicInfo(officer);

                System.out.println("Nhập level: ");
                int level = Integer.parseInt(scanner.nextLine());
                officers = addOfficer(officer);
                break;
            case 2:
                officer = new Engineer();
                inputBasicInfo(officer);
                System.out.println("Nhập bằng cấp: ");
                String branch = scanner.nextLine();

                //Engineer("Bảo", 19, "Nam", "28 NTP", "Bằng ĐH Bách Khoa");
                officers = addOfficer(officer);
                break;
            case 3:
        }
    }

    private void editOfficeView() {
        System.out.println("Sửa thông tin cán bo: ");
        System.out.println("Nhap mã cán bộ muốn sửa: ");
        long id = Long.parseLong(scanner.nextLine());
        Officer officeEdit = null;
        for (Officer o : officers) {
            if (o.getId() == id) {
                officeEdit = o;
                break;
            }
        }
        if (officeEdit instanceof Worker) {
            showMenu(officeEdit);

            int actionMenuEditInfoWorker = Integer.parseInt(scanner.nextLine());
            switch (actionMenuEditInfoWorker) {
                case 1:
                    System.out.println("Nhập tên mới: ");
                    String sName = scanner.nextLine();
                    officeEdit.setName(sName);

                    editOfficesById(officers, id, officeEdit);
                    break;
                case 2:
                    System.out.println("Nhập tuổi mới: ");
                    int sAge = Integer.parseInt(scanner.nextLine());
                    officeEdit.setAge(sAge);

                    editOfficesById(officers, id, officeEdit);
                    break;
                case 3:
                    System.out.println("Nhập địa chỉ mới: ");
                    String sAddress = scanner.nextLine();
                    officeEdit.setAddress(sAddress);

                    editOfficesById(officers, id, officeEdit);
                    break;
                case 5:
                    System.out.println("Nhập thông tin level mới: ");
                    int sLevel = Integer.parseInt(scanner.nextLine());

                    Worker worker = (Worker) officeEdit;
                    worker.setLevel(sLevel);
            }
        }
        if (officeEdit instanceof Engineer) {
            showMenu(officeEdit);
            int actionMenuEditInfoEngineer = Integer.parseInt(scanner.nextLine());
            switch (actionMenuEditInfoEngineer) {
                case 1:
                    System.out.println("Nhập tên mới: ");
                    String sName = scanner.nextLine();
                    officeEdit.setName(sName);

                    editOfficesById(officers, id, officeEdit);
                case 2:
                    System.out.println("Nhập tuổi mới: ");
                    int sAge = Integer.parseInt(scanner.nextLine());
                    officeEdit.setAge(sAge);

                    editOfficesById(officers, id, officeEdit);
                    break;
                case 3:
                    System.out.println("Nhập địa chỉ mới: ");
                    String sAddress = scanner.nextLine();
                    officeEdit.setAddress(sAddress);

                    editOfficesById(officers, id, officeEdit);
                    break;
                case 4:
                    System.out.println("Nhập bằng cấp mới: ");
                    String branch = scanner.nextLine();
                    Engineer engineer = (Engineer) officeEdit;

                    engineer.setBranch(branch);
            }
        }
    }

    public void showMenu(Officer officer) {
        System.out.println("Chọn thông tin cần sửa: ");
        System.out.println("Nhập 1. Sửa tên ");
        System.out.println("Nhập 2. Sửa tuổi ");
        System.out.println("Nhập 3. Sửa địa chỉ");
        System.out.println("Nhập 4. Sửa giới tính");
        if (officer instanceof Worker) {
            System.out.println("Nhập 5. Sửa level");
        }
        if (officer instanceof Engineer) {
            System.out.println("Nhập 5. Sửa bằng cấp");
        }
    }
    public void editOfficesById(Officer[] officers, long idOffice, Officer o) {
        for (Officer item : officers) {
            if (item.getId() == idOffice) {
                item.setName(o.getName());
                item.setAddress(o.getAddress());
                item.setAge(o.getAge());
                item.setGender(o.getGender());
                break;
            }
        }
    }
    public static void main(String[] args) {

        /**
            Sửa 1 cán bộ theo ID
            Xóa 1 cán bộ theo ID
            Sắp xếp cán bộ theo tên, theo tuổi
         */
        ManagerOfficer managerOfficer = new ManagerOfficer();
    }

    private void showOffices(Officer[] officers) {
        for (Officer officer : officers) {
            System.out.println(officer);
        }
    }
    private void inputBasicInfo(Officer officer) {
        officer.setId(System.currentTimeMillis());
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();


        officer.setName(name);
        officer.setAge(age);
        officer.setGender(gender);
        officer.setAddress(address);
    }
    private Officer[] addOfficer(Officer officer) {
        Officer[] officersNew = Arrays.copyOf(officers, officers.length + 1);
        officersNew[officersNew.length-1] = officer;

        return officersNew;
    }


}
