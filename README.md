# Trình xác thực trạng thái đăng nhập Keycloak

Một trình xác thực Keycloak tùy chỉnh kiểm tra trạng thái đăng nhập của người dùng trong các luồng xác thực.

## Tính năng
- Logic xác thực tùy chỉnh cho Keycloak
- Dễ dàng tích hợp vào các luồng xác thực của Keycloak

## Cài đặt
1. Biên dịch dự án bằng Maven:
   ```sh
   ./mvnw clean package
   ```
2. Sao chép file JAR được tạo ra từ `target/keycloak-login-status-authenticator.jar` vào thư mục `providers/` của máy chủ Keycloak.
3. Khởi động lại máy chủ Keycloak.

## Sử dụng
1. Đăng nhập vào trang quản trị Keycloak.
2. Vào **Authentication** > **Flows**.
3. Thêm trình xác thực mới vào luồng mong muốn.

## Phát triển
- Java 11 hoặc cao hơn
- Maven

## Cấu trúc dự án
- `src/main/java/com/example/keycloak/login/status/authenticator/` - Triển khai trình xác thực
- `src/main/resources/META-INF/services/` - Cấu hình nhà cung cấp dịch vụ
