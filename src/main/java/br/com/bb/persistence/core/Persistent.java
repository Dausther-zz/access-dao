package br.com.bb.persistence.core;

import java.io.Serializable;

public interface Persistent<KEY extends Serializable> extends Serializable, Identifiable<KEY>, Versionable {

}
