package pl.ateam.disasteralerts.util;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Getter
@MappedSuperclass
public class EntityAudit {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;

    @Version
    private long version;

    private Date createDate;

    private Date updateDate;

    @PrePersist
    public void setCreateDate() {
        this.createDate = new Date();
    }

    @PreUpdate
    public void setUpdateDate() {
        this.updateDate = new Date();
    }
}