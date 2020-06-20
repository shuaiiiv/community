package com.nowcoder.community.entity;

/*
* 分页的封装类，分页本身可以作为一个功能模块进行移植，所以进行封装。
* 使用的方式是每次换页时刷新页面
* 不是那种异步的进行
* */
public class Page {
    //当前页码
    private int current=1;
    //每页条数
    private int limit=10;
    //数据总共量
    private int rows;
    //刷新页面的路径
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1)
        {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1&&limit<=100)
        {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0)
        {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取数据库查询的初始值
    public int getOffset()
    {
        return (current-1)*limit;
    }

    //计算总共的页数
    public int getTotal()
    {
        if(rows%limit==0)
        {
            return rows/limit;
        }
        else return rows/limit+1;
    }

    //到第几页
    public int getTo()
    {
        int to=current+2;
        int total=getTotal();
        return to>total? total:to;
    }
    //从第几页
    public int getFrom()
    {
        int from=current-2;
        return from<1?1:from;
    }

    @Override
    public String toString() {
        return "Page{" +
                "current=" + current +
                ", limit=" + limit +
                ", rows=" + rows +
                ", path='" + path + '\'' +
                '}';
    }
}
