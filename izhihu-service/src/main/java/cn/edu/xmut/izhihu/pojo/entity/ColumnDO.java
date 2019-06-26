package cn.edu.xmut.izhihu.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "column")
public class ColumnDO {
    /**
     * 专栏id
     */
    @Id
    @Column(name = "column_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer columnId;

    /**
     * 专栏名称
     */
    @Column(name = "column_name")
    private String columnName;

    /**
     * 创建人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否已删除（1删除0未删除）
     */
    private Integer del;

    /**
     * 专栏介绍
     */
    private String desc;

    /**
     * 获取专栏id
     *
     * @return column_id - 专栏id
     */
    public Integer getColumnId() {
        return columnId;
    }

    /**
     * 设置专栏id
     *
     * @param columnId 专栏id
     */
    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    /**
     * 获取专栏名称
     *
     * @return column_name - 专栏名称
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 设置专栏名称
     *
     * @param columnName 专栏名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 获取创建人id
     *
     * @return user_id - 创建人id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置创建人id
     *
     * @param userId 创建人id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否已删除（1删除0未删除）
     *
     * @return del - 是否已删除（1删除0未删除）
     */
    public Integer getDel() {
        return del;
    }

    /**
     * 设置是否已删除（1删除0未删除）
     *
     * @param del 是否已删除（1删除0未删除）
     */
    public void setDel(Integer del) {
        this.del = del;
    }

    /**
     * 获取专栏介绍
     *
     * @return desc - 专栏介绍
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置专栏介绍
     *
     * @param desc 专栏介绍
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}