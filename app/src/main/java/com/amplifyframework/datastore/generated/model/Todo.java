package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Todo type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Todos", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Todo implements Model {
  public static final QueryField ID = field("Todo", "id");
  public static final QueryField DATO = field("Todo", "dato");
  public static final QueryField FECHA = field("Todo", "fecha");
  public static final QueryField COMENTARIO = field("Todo", "comentario");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String dato;
  private final @ModelField(targetType="String", isRequired = true) String fecha;
  private final @ModelField(targetType="String", isRequired = true) String comentario;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getDato() {
      return dato;
  }
  
  public String getFecha() {
      return fecha;
  }
  
  public String getComentario() {
      return comentario;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Todo(String id, String dato, String fecha, String comentario) {
    this.id = id;
    this.dato = dato;
    this.fecha = fecha;
    this.comentario = comentario;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Todo todo = (Todo) obj;
      return ObjectsCompat.equals(getId(), todo.getId()) &&
              ObjectsCompat.equals(getDato(), todo.getDato()) &&
              ObjectsCompat.equals(getFecha(), todo.getFecha()) &&
              ObjectsCompat.equals(getComentario(), todo.getComentario()) &&
              ObjectsCompat.equals(getCreatedAt(), todo.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), todo.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDato())
      .append(getFecha())
      .append(getComentario())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Todo {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("dato=" + String.valueOf(getDato()) + ", ")
      .append("fecha=" + String.valueOf(getFecha()) + ", ")
      .append("comentario=" + String.valueOf(getComentario()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static DatoStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Todo justId(String id) {
    return new Todo(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      dato,
      fecha,
      comentario);
  }
  public interface DatoStep {
    FechaStep dato(String dato);
  }
  

  public interface FechaStep {
    ComentarioStep fecha(String fecha);
  }
  

  public interface ComentarioStep {
    BuildStep comentario(String comentario);
  }
  

  public interface BuildStep {
    Todo build();
    BuildStep id(String id);
  }
  

  public static class Builder implements DatoStep, FechaStep, ComentarioStep, BuildStep {
    private String id;
    private String dato;
    private String fecha;
    private String comentario;
    @Override
     public Todo build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Todo(
          id,
          dato,
          fecha,
          comentario);
    }
    
    @Override
     public FechaStep dato(String dato) {
        Objects.requireNonNull(dato);
        this.dato = dato;
        return this;
    }
    
    @Override
     public ComentarioStep fecha(String fecha) {
        Objects.requireNonNull(fecha);
        this.fecha = fecha;
        return this;
    }
    
    @Override
     public BuildStep comentario(String comentario) {
        Objects.requireNonNull(comentario);
        this.comentario = comentario;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String dato, String fecha, String comentario) {
      super.id(id);
      super.dato(dato)
        .fecha(fecha)
        .comentario(comentario);
    }
    
    @Override
     public CopyOfBuilder dato(String dato) {
      return (CopyOfBuilder) super.dato(dato);
    }
    
    @Override
     public CopyOfBuilder fecha(String fecha) {
      return (CopyOfBuilder) super.fecha(fecha);
    }
    
    @Override
     public CopyOfBuilder comentario(String comentario) {
      return (CopyOfBuilder) super.comentario(comentario);
    }
  }
  
}
