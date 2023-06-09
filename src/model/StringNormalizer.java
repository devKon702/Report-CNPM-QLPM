
package model;


public class StringNormalizer {
    public static String normalizeString(String input) {
        // Xóa bỏ kí tự trống (trắng) đầu dòng
        String trimmed = input.trim();
        
        // Xóa bỏ kí tự trống cuối dòng
        String withoutTrailingSpaces = trimmed.replaceAll("\\s+$", "");
        
        // Xóa bỏ kí tự trống không hợp lệ (ký tự trống bị thừa)
        String normalized = withoutTrailingSpaces.replaceAll("\\s+", " ");
        
        return normalized;
    }
}
