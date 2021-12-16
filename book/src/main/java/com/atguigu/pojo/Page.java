package com.atguigu.pojo;

import java.util.List;

/**
 * 分页的对象
 * @author xiu
 * @create 2021-11-12 17:59
 */
public class Page<T> {
//    默认值
    public static final Integer PAGE_SIZE =4;
//    当前页码
    private Integer pageNo;
//    总页码
    private Integer pageTotal;
//    总记录数
    private Integer pageTotalCount;
//    每页显示数量
    private Integer pageSize=PAGE_SIZE;
//    当前页数据
    private List<T> items;
//    分页的位置，前台还是后台
    private String url;

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", pageSize=" + pageSize +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
