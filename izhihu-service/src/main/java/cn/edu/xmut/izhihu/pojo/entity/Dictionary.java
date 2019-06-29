package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "dictionary")
public class Dictionary {
    /**
     * id
     */
    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer pkId;

    /**
     * 父节点id
     */
    @Column(name = "fk_parent")
    private Integer fkParent;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 标签
     */
    private String tag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 类别
     */
    private String category;

    /**
     * 是否允许有子节点 0否，1是
     */
    @Column(name = "allow_child")
    private Boolean allowChild;

    /**
     * 获取id
     *
     * @return pk_id - id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 设置id
     *
     * @param pkId id
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 获取父节点id
     *
     * @return fk_parent - 父节点id
     */
    public Integer getFkParent() {
        return fkParent;
    }

    /**
     * 设置父节点id
     *
     * @param fkParent 父节点id
     */
    public void setFkParent(Integer fkParent) {
        this.fkParent = fkParent;
    }

    /**
     * 获取字典名称
     *
     * @return name - 字典名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置字典名称
     *
     * @param name 字典名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取标签
     *
     * @return tag - 标签
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置标签
     *
     * @param tag 标签
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
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
     * 获取层级
     *
     * @return level - 层级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置层级
     *
     * @param level 层级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取类别
     *
     * @return category - 类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置类别
     *
     * @param category 类别
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 获取是否允许有子节点 0否，1是
     *
     * @return allow_child - 是否允许有子节点 0否，1是
     */
    public Boolean getAllowChild() {
        return allowChild;
    }

    /**
     * 设置是否允许有子节点 0否，1是
     *
     * @param allowChild 是否允许有子节点 0否，1是
     */
    public void setAllowChild(Boolean allowChild) {
        this.allowChild = allowChild;
    }
}