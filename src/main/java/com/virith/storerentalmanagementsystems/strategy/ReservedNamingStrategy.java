package com.virith.storerentalmanagementsystems.strategy;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class ReservedNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {
    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        StringBuilder nameBuilder = new StringBuilder(name);
        nameBuilder.setCharAt(0, Character.toUpperCase(name.charAt(0)));
        String pascalCaseName = nameBuilder.toString().replaceAll("_", "");
        return new Identifier(pascalCaseName, quoted);
    }
}