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

![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/b381c494-d9ce-45ab-988a-4a02b1eee0e8)

## Thêm phụ thuộc maven 

```
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

##   Triển khai mô hình MongoDB
          
### Chúng ta có một lớp mô hình đơn giản Post.java

```
@Document(collection = "JobPost")
public class Post {
    private String profile;
    private String desc;
    private int exp;

    public Post() {
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
```

- Chúng ta sử dụng chú thích @Document để đặt tên collection  sẽ được mô hình sử dụng. Nếu collection không tồn tại, MongoDB sẽ tạo nó.
- @Document được sử dụng để ánh xạ một lớp tới cơ sở dữ liệu noSQL (cụ thể là mongoDB), nó đại diện cho một tài liệu MongoDB.

### Triển khai API Spring Boot MongoDB 

Việc triển khai API diễn ra trong kho lưu trữ. Nó hoạt động như một liên kết giữa mô hình và cơ sở dữ liệu và có tất cả các phương thức cho hoạt động CRUD.

```
public interface PostRepository extends MongoRepository<Post,String>{

}
```

### Connect Mongodb

Bây giờ, chúng ta đã sẵn sàng để tạo Ứng dụng Sping boot  của mình và chạy các phương thức để xem điều gì sẽ xảy ra.

Để kết nối với MongoDB Atlas, chúng tôi chỉ định chuỗi kết nối trong tệp application.properties trong thư mục src/main/resource. Có thể tìm thấy chuỗi kết nối cho một cụm trong Giao diện người dùng Atlas . Không cần viết mã liên quan đến kết nối trong bất kỳ tệp nào khác. Spring Boot đảm nhận việc kết nối cơ sở dữ liệu cho chúng ta.
chọn  connect -> Driver -> copy url tại  Add your connection string into your application code
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/c283ef77-a7a1-4fdc-9edf-26d582992b9a)
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/25dcbfd0-8d29-42b2-a80b-5997d68c3cad)
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/903aaa1d-4674-4905-a250-4782af586da7)

cấu hình application 

```
spring.data.mongodb.uri=mongodb+srv://<username>:<pwd>@<cluster>.mongodb.net/<tenDabase>
spring.data.mongodb.database=<tenDabase>

spring.data.mongodb.uri=mongodb+srv://minigame:ejd2UGqNEHQm9aZz@cluster0.ptrpm.mongodb.net/?retryWrites=true&w=majority
spring.data.mongodb.database=demo
```

### Service
- PostService.class

```
public interface PostService {

    List<Post> getAllPosts();

    Post addPost(@RequestBody Post post);

}
```

- PostServiceImpl.class

```
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repo;

    @Override
    public List<Post> getAllPosts() {
        return  repo.findAll();
    }

    @Override
    public Post addPost(Post post) {
        return repo.save(post);
    }
}

```

### Hiển thị Tất cả các bài viết và thêm mới bài viết 

```
@RestController
public class PostController
{

    @Autowired
    private PostService postService;


    @GetMapping("/allPosts")
    public List<Post> getAllPosts()
    {
        return postService.getAllPosts();
    }


    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return postService.addPost(post);
    }

}

```

## Chạy thử MongoDB 

- Khi ứng dụng đang chạy, chúng tôi có thể thử lưu người dùng mới bằng cách sử dụng API này:
 http://localhost:8080/post
Vì đây sẽ là một yêu cầu POST nên chúng tôi cũng sẽ gửi dữ liệu JSON:

```
{
    "profile":"324345345",
    "desc": "jdfhkjshkjgfd",
    "exp": 12
}
```

Khi chúng tôi trả lại phản hồi Mongo, chúng tôi sẽ nhận được một cái gì đó như sau:

![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/7e28de03-3ed3-408a-8dee-3ddb93560165)

- Bạn có thể nhận được tất cả người dùng bằng cách sử dụng API dưới dạng yêu cầu GET:
 http://localhost:8080/allPosts

Chúng tôi sẽ lấy lại một cái gì đó như Sau:
![image](https://github.com/thangdtph27626/SpringBoot_MongoDB.github.io/assets/109157942/323d3aa9-7d57-4b47-9ffa-e2b61138c69f)


## MongoTemplate vs MongoRepository
- MongoTemplate cung cấp nhiều quyền kiểm soát hơn khi truy vấn dữ liệu và lấy dữ liệu nào từ cơ sở dữ liệu.
- Kho lưu trữ dữ liệu mùa xuân cung cấp cho chúng tôi triển vọng thuận tiện về cách tìm nạp dữ liệu.
- MongoTemplate phụ thuộc vào cơ sở dữ liệu. Điều này có nghĩa là, với kho lưu trữ Dữ liệu Spring, bạn có thể dễ dàng chuyển sang một cơ sở dữ liệu khác hoàn toàn bằng cách sử dụng một kho lưu trữ Dữ liệu Spring khác cho MySQL hoặc Neo4J hoặc bất kỳ thứ gì khác. Điều này là không thể với MongoTemplate.

## Kết thúc 

Trong bài học này, chúng ta đã xem xét cách MongoTemplate có thể cung cấp cho chúng ta nhiều quyền kiểm soát hơn đối với kho lưu trữ Dữ liệu Spring nhưng cũng có thể hơi phức tạp khi có các truy vấn sâu hơn. Vì vậy, đây hoàn toàn là quyết định của bạn nên chọn gì khi bạn phát triển ý tưởng của mình
link github https://github.com/thangdtph27626/SpringBoot_MongoDB
