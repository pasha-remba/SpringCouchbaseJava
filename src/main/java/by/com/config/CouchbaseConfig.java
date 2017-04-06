package by.com.config;

import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import java.util.Arrays;
import java.util.List;

public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    protected List<String> getBootstrapHosts() {
        return Arrays.asList("host1", "host1");
    }

    protected String getBucketName() {
        return "default";
    }

    protected String getBucketPassword() {
        return "";
    }

}
