package org.example.clientlist;

import java.util.ArrayList;
import java.util.List;

public class ClientList {
    private List<Client> list = new ArrayList<>();
    public ClientList() {
        list.add(new Client("Mai Văn Hoàn", "20/08/1983", "Hà Nội", true));
        list.add(new Client("Nguyễn Văn Nam", "21/08/1983", "HCM", true));
        list.add(new Client("Nguyễn Thái Hoà", "22/08/1983", "Dubai", true));
        list.add(new Client("Trần Đăng Khoa", "23/08/1983", "Hà Nội", true));
        list.add(new Client("Nguyễn Đình Thi", "24/08/1983", "Hà Nội", false));
    }

    public List<Client> getList() {
        return list;
    }
}
