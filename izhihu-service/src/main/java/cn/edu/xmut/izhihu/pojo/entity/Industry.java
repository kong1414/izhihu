package cn.edu.xmut.izhihu.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "industry")
public class Industry {
    /**
     * 行业id
     */
    @Id
    @Column(name = "indu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer induId;

    /**
     * 行业类别id
     */
    @Column(name = "indu_class_id")
    private Integer induClassId;

    /**
     * 行业名称
     */
    @Column(name = "indu_name")
    private String induName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取行业id
     *
     * @return indu_id - 行业id
     */
    public Integer getInduId() {
        return induId;
    }

    /**
     * 设置行业id
     *
     * @param induId 行业id
     */
    public void setInduId(Integer induId) {
        this.induId = induId;
    }

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
     * 获取行业名称
     *
     * @return indu_name - 行业名称
     */
    public String getInduName() {
        return induName;
    }

    /**
     * 设置行业名称
     *
     * @param induName 行业名称
     */
    public void setInduName(String induName) {
        this.induName = induName == null ? null : induName.trim();
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