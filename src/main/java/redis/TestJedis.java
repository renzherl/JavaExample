package redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;

/**
 * Created by mi on 2017/10/31.
 */
public class TestJedis {
    private static Jedis jedis;
    private static JedisCluster jedisCluster;
    private static final String HOST = "redis-ad-service004-staging-dba.marathon.mesos-staging";
    private static final int PORT = 11317;

    private static void setup() {
        //jedis = new Jedis(HOST, PORT);
        try {
            jedisCluster = new JedisCluster(new HostAndPort(HOST, PORT));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    private static void testString() {
        jedisCluster.set("name", "xinxin");
        System.out.println(jedisCluster.get("name"));
    }

    public static void main(String args[]) {
        System.out.println("Hello, Redis");
        setup();
        testString();
        //RedisPoolUtil.getJedis().set("newname", "中文测试");
        //System.out.println(RedisPoolUtil.getJedis().get("newname"));

    }

}
