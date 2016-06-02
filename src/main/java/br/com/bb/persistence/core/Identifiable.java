package br.com.bb.persistence.core;

import java.io.Serializable;

public interface Identifiable<K extends Serializable> {

    K getId();
}
