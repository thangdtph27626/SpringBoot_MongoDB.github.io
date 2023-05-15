<p align="center">
 <h1 align="center">Hướng dẫn sử dụng mongoDb trong spring boot</h1>
</p>

# Cách sử dụng springBoot với MongoDB
 MongoDB và Spring Boot tương tác bằng lớp MongoTemplate và giao diện MongoRepository .
- MongoTemplate — MongoTemplate triển khai một bộ API sẵn sàng sử dụng. Một lựa chọn tốt cho các hoạt động như cập nhật, tổng hợp và các thao tác khác, MongoTemplate cung cấp khả năng kiểm soát tốt hơn đối với các truy vấn tùy chỉnh.
- MongoRepository — MongoRepository được sử dụng cho các truy vấn cơ bản liên quan đến tất cả hoặc nhiều trường của tài liệu. Ví dụ bao gồm tạo dữ liệu, xem tài liệu, v.v.

# Thiết lập mongodb

- Bước 1: đăng ký tài khoản [mongodb](https://account.mongodb.com/account/login)
- Bước 2: Tạo mới một project 
 create project -> nhập tên project -> next -> thêm members -> create project 
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/d510ff7f-4b91-401a-942a-a8b2bac7b44f)
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/53929f34-11a7-41fc-9fa5-4de60578fe83)
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/3a398f2f-8946-4c38-a815-217666ee5fbe)
- Bước 3: Tạo một database  
 Build a Database -> chọn MO -> create 
 
 ![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/6fd7ec74-d7e6-4797-89a7-b8bad145d2af)
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/59c22c65-1338-42d0-b94a-7328e2f7ebac)

- Bước 4: cấu hình Security Quickstart
Chọn Username and Password -> nhập user name và password -> create user
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/97fe1010-568c-4e4f-aedc-9c5fba38f4e1)

Thiết lập địa chỉ ip kết nối 
chọn My Local Environment -> click Add My Current IP Address
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/20ca1790-fe6d-4931-a41d-f4ad68bebdd5)

-> sau khi cấu hình xong chọn  Finish and Close -> go to database 

![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/3055383d-5488-40ec-a9c3-62f6243842b4)

# Khởi tạo dự án spring boot và  MongoDB

## cấu trúc thư mục 



