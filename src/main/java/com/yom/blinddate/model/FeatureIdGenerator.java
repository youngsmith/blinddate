package com.yom.blinddate.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.util.Assert;

public class FeatureIdGenerator implements IdentifierGenerator, Configurable {

  public static final String FEATURE_TYPE = "feature_type";
  public static final String STRATEGY = "com.yom.blinddate.model.FeatureIdGenerator";

  private static final String QUERY = "SELECT usf_next_feature_id(?)";

  private Properties properties;

  @Override
  public void configure(Type type, Properties params, ServiceRegistry serviceRegistry)
      throws MappingException {
    properties = params;
  }

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object)
      throws HibernateException {
    if (object == null) {
      return null;
    }
    String featureType = properties.getProperty(FEATURE_TYPE);
    Assert.hasText(featureType, "featureType have text; it must not be null, empty, or blank");

    Connection connection = session.connection();
    try (PreparedStatement stmt = connection.prepareStatement(QUERY)) {
      stmt.setString(1, featureType);
      ResultSet rs = stmt.executeQuery();
      rs.next();
      return rs.getLong(1);
    } catch (SQLException sqlException) {
      throw new HibernateException(sqlException);
    }
  }
}
