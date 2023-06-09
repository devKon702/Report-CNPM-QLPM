package model;

public class InputValidator {
     public static boolean validateFullName(String fullName) {
         // Kiểm tra không có ký tự đặc biệt, không có số và phải có dấu
         return fullName.matches("^[\\p{L}\\s]+$") && !fullName.matches(".*\\d.*");
    }

  public static boolean validatePhoneNumber(String phoneNumber) {
         // Kiểm tra bắt đầu bằng số 0 và độ dài là 10 số
        return phoneNumber.matches("^0\\d{9}$");
    }

    public static boolean validateEmail(String email) {
         // Kiểm tra định dạng email
        return email.matches("^[A-Za-z0-9+_.-]+@(gmail\\.com|student\\.ptithcm\\.edu\\.vn)$");
    }

     public static boolean validateIdentityCard(String identityCard) {
         // Kiểm tra độ dài là 10 hoặc 12 số
        return identityCard.matches("^(\\d{10}|\\d{12})$");
    }
}
