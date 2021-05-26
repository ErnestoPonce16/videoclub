package com.soa.videoclub.model;

import javax.persistence.*;

import org.apache.solr.client.solrj.beans.Field;
import org.hibernate.annotations.Index;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

@Entity
@Table(name = "user")
@SolrDocument(collection="user")
public class User implements Serializable {
   

    /**
	 * 
	 */
	private static final long serialVersionUID = -2770986581822044012L;
	@Id
	@Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Indexed(name="nombre",type="string")
    @Column(length = 100, nullable = true)
    private String nombre;
	
	@Indexed(name="apellido",type="string")
    @Column(length = 100, nullable = true)
    private String apellido;
	
	@Indexed(name="email",type="string")
    @Column(length = 100, nullable = true)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
