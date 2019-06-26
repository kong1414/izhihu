package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "industry_class")
public class IndustryClassDO {
    /**
     * 行业类别id
     */
    @Id
    @Column(name = "indu_class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer induClassId;

    /**
     * 行业类别名称
     */
    @Column(name = "indu_class_name")
    private String induClassName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取行业类别id
     *
     * @return indu_class_id - 行业类别id
     */
    public Integer getInduClassId() {
        return induClassId;
    }

    /**
     * 设置行业类别id
     *
     * @param induClassId 行业类别id
     */
    public void setInduClassId(Integer induClassId) {
        this.induClassId = induClassId;
    }

    /**
     * 获取行业类别名称
     *
     * @return indu_class_name - 行业类别名称
     */
    public String getInduClassName() {
        return induClassName;
    }

    /**
     * 设置行业类别名称
     *
     * @param induClassName 行业类别名称
     */
    public void setInduClassName(String induClassName) {
        this.induClassName = induClassName == null ? null : induClassName.trim();
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
}