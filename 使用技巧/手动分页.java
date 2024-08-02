import java.util.Collections;
import java.util.List;

public class PaginationUtils {

    public static <T> List<T> getCurPageData(List<T> list, int pageNum, int pageSize) {
        // 参数校验
        if (list == null || pageNum <= 0 || pageSize <= 0) {
            throw new IllegalArgumentException("分页参数错误");
        }

        int fromIndex = Math.max(0, (pageNum - 1) * pageSize);

        if (fromIndex >= list.size()) {
            return Collections.emptyList();
        }

        int toIndex = Math.min(fromIndex + pageSize, list.size());
        return list.subList(fromIndex, toIndex);
    }
}
