package by.com.config;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CustomConversions;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCouchbaseRepositories
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

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(Arrays.asList(DateTimeToLongConverter.INSTANCE, NumberToDateTimeConverter.INSTANCE));
    }

    @WritingConverter
    public enum DateTimeToLongConverter implements Converter<DateTime, Long>{
        INSTANCE;

        public Long convert(DateTime dateTime) {
            return dateTime == null ? null : dateTime.toDate().getTime();
        }
    }

    @ReadingConverter
    public enum NumberToDateTimeConverter implements Converter<Number, DateTime>{
        INSTANCE;

        public DateTime convert(Number number) {
            return number == null ? null : new DateTime(number.longValue());
        }
    }
}
