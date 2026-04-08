package hello.core.lifecycle;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {  인터페이스 방식 생명주기 콜백
public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시
    public void connect(){
        System.out.println("connect = " + url);
    }

    public void call(String messge){
        System.out.println("call: "+url+" messge = " + messge);
    }

    public void disconnect(){
        System.out.println("close " + url);
    }


    @PostConstruct
    public void init(){
        System.out.println("init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("close");
        disconnect();
    }
}

