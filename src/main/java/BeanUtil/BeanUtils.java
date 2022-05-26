package BeanUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: 使用 BeanUtil 将 Map 与 Bean 进行相互转换
 * @author: aiqiulin
 * @Date: 2022/05/26 10:25
 */
public class BeanUtils {
    public static void main(String[] args) {

    }
   public static <T> T mapToBean(Map<String,Object> source,Class<T> destBeanClass){
        return BeanUtil.mapToBean(source,destBeanClass,false,new CopyOptions());
   }
    /**
     * 将List<Map<String,Object>>转换为List<Bean>
     * @param sourceList
     * @param destBeanClass
     */
    public static <T> List<T> listToBean(List<Map<String,Object>> sourceList,Class<T> destBeanClass){
        List<T> beanList = new ArrayList<>();
        for (Map<String, Object> map:sourceList){
            T dest =mapToBean(map,destBeanClass);
            beanList.add(dest);
        }
        return beanList;
    }
    /**
     *  将List<Bean>转换为List<Map<String, Object>>
     */
    public static <T> List<Map<String, Object>> beansToList(List<T> sourceList){
        List<Map<String, Object>> destList = new ArrayList<>();
        for (Object source:sourceList){
            Map<String, Object> map = BeanUtil.beanToMap(source);
            destList.add(map);
        }
        return destList;
    }
}
