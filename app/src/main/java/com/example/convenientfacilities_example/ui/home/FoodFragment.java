package com.example.convenientfacilities_example.ui.home;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.convenientfacilities_example.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class FoodFragment extends Fragment {

    EditText edit;
    TextView text;

    String Key = "NO2EbE%2Bu5KtWhuLp1rQALIAtWWnRDgj9mCuelgBAxRS%2Frxi12vyAMLBp%2F3KEanPiRfbO3hwggbbpZ%2B0XtKIolQ%3D%3D";
    String data;

    public FoodFragment() {

    }

    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);




    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_food, container, false);


        StrictMode.enableDefaults();


        edit = (EditText) view.findViewById(R.id.edit);
        text = (TextView) view.findViewById(R.id.text);
        TextView status1 = (TextView) view.findViewById(R.id.result);
    boolean initem = false, inbsnsSector = false, inbsnsCond = false, inbsnsNm = false, inaddrRoad = false, inaddrJibun = false;
    boolean inmenu = false, intel = false, inspecDate = false, inovrdDate = false, ingugun = false, indataDay = false, inlat = false, inlng = false;

    String bsnsSector = null, bsnsCond = null, bsnsNm = null, addrRoad = null, addrJibun = null;
    String menu = null, tel = null, specDate = null, ovrdDate = null, gugun = null, dataDay = null, lat = null, lng = null;

        try{
        URL url = new URL("http://apis.data.go.kr/6260000/BusanTblFnrstrnStusService/getTblFnrstrnStusInfo?"
                + "numOfRows=15&pageNo=1&serviceKey="
                + "NO2EbE%2Bu5KtWhuLp1rQALIAtWWnRDgj9mCuelgBAxRS%2Frxi12vyAMLBp%2F3KEanPiRfbO3hwggbbpZ%2B0XtKIolQ%3D%3D"
        );
        XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
        XmlPullParser parser = parserCreator.newPullParser();

        parser.setInput(url.openStream(), null);

        int parserEvent = parser.getEventType();
        System.out.println("파싱시작합니다.");


        while (parserEvent != XmlPullParser.END_DOCUMENT){
            switch(parserEvent){
                case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행
                    if(parser.getName().equals("bsnsSector")){ //title 만나면 내용을 받을수 있게 하자
                        inbsnsSector = true;
                    }
                    if(parser.getName().equals("bsnsCond")){ //address 만나면 내용을 받을수 있게 하자
                        inbsnsCond = true;
                    }
                    if(parser.getName().equals("bsnsNm")){ //mapx 만나면 내용을 받을수 있게 하자
                        inbsnsNm = true;
                    }
                    if(parser.getName().equals("addrRoad")){ //mapy 만나면 내용을 받을수 있게 하자
                        inaddrRoad = true;
                    }
                    if(parser.getName().equals("addrJibun")){ //mapy 만나면 내용을 받을수 있게 하자
                        inaddrJibun = true;
                    }
                    if(parser.getName().equals("menu")){ //mapy 만나면 내용을 받을수 있게 하자
                        inmenu = true;
                    }
                    if(parser.getName().equals("tel")){ //mapy 만나면 내용을 받을수 있게 하자
                        intel = true;
                    }
                    if(parser.getName().equals("specDate")){ //mapy 만나면 내용을 받을수 있게 하자
                        inspecDate = true;
                    }
                    if(parser.getName().equals("ovrdDate")){ //mapy 만나면 내용을 받을수 있게 하자
                        inovrdDate = true;
                    }
                    if(parser.getName().equals("gugun")){ //mapy 만나면 내용을 받을수 있게 하자
                        ingugun = true;
                    }
                    if(parser.getName().equals("dataDay")){ //mapy 만나면 내용을 받을수 있게 하자
                        indataDay = true;
                    }
                    if(parser.getName().equals("lat")){ //mapy 만나면 내용을 받을수 있게 하자
                        inlat = true;
                    }
                    if(parser.getName().equals("lng")){ //mapy 만나면 내용을 받을수 있게 하자
                        inlng = true;
                    }
                    if(parser.getName().equals("message")){ //message 태그를 만나면 에러 출력
                        status1.setText(status1.getText()+"에러");
                        //여기에 에러코드에 따라 다른 메세지를 출력하도록 할 수 있다.
                    }
                    break;

                case XmlPullParser.TEXT://parser가 내용에 접근했을때
                    if(inbsnsSector){ //isTitle이 true일 때 태그의 내용을 저장.
                        bsnsSector = parser.getText();
                        inbsnsSector = false;
                    }
                    if(inbsnsCond){ //isAddress이 true일 때 태그의 내용을 저장.
                        bsnsCond = parser.getText();
                        inbsnsCond = false;
                    }
                    if(inbsnsNm){ //isMapx이 true일 때 태그의 내용을 저장.
                        bsnsNm = parser.getText();
                        inbsnsNm = false;
                    }
                    if(inaddrRoad){ //isMapy이 true일 때 태그의 내용을 저장.
                        addrRoad= parser.getText();
                        inaddrRoad = false;
                    }
                    if(inaddrJibun){ //isMapy이 true일 때 태그의 내용을 저장.
                        addrJibun = parser.getText();
                        inaddrJibun = false;
                    }
                    if(inmenu){ //isMapy이 true일 때 태그의 내용을 저장.
                        menu = parser.getText();
                        inmenu = false;
                    }
                    if(intel){ //isMapy이 true일 때 태그의 내용을 저장.
                        tel = parser.getText();
                        intel = false;
                    }
                    if(inspecDate){ //isMapy이 true일 때 태그의 내용을 저장.
                        specDate = parser.getText();
                        inspecDate = false;
                    }
                    if(inovrdDate){ //isMapy이 true일 때 태그의 내용을 저장.
                        ovrdDate = parser.getText();
                        inovrdDate = false;
                    }
                    if(ingugun){ //isMapy이 true일 때 태그의 내용을 저장.
                        gugun = parser.getText();
                        ingugun = false;
                    }
                    if(indataDay){ //isMapy이 true일 때 태그의 내용을 저장.
                        dataDay = parser.getText();
                        indataDay = false;
                    }
                    if(inlat){ //isMapy이 true일 때 태그의 내용을 저장.
                        lat = parser.getText();
                        inlat = false;
                    }
                    if(inlng){ //isMapy이 true일 때 태그의 내용을 저장.
                        lng = parser.getText();
                        inlng = false;
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if(parser.getName().equals("item")){
                        status1.setText(status1.getText()+"업종 : " + bsnsSector
                                +"\n 업태 : "+ bsnsCond +"\n 업소명 : "+ bsnsNm +"\n 소재지(도로명) : " + addrRoad +  "\n 소재지(지번) : " + addrJibun + "\n 메뉴 : " + menu
                                +"\n 전화번호 : " + tel + "\n 지정일자 : " + specDate + "\n 재지정일자 : " + ovrdDate+ "\n 구군명 : " + gugun+ "\n 데이터기준일자 : " + dataDay+ "\n 위도 : " + lat+ "\n 경도 : " + lng
                                +"\n"+"\n");
                        initem = false;
                    }
                    break;
            }
            parserEvent = parser.next();
        }
    } catch(Exception e){
        status1.setText("에러가..났습니다...");
    }
        return view;
}


    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.button:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        data = getXmlData();

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(data);
                            }
                        });
                    }
                }).start();

                break;


        }
    }


    String getXmlData() {

        StringBuffer buffer = new StringBuffer();

        String str = edit.getText().toString();
        String location = null;
        try {
            location = URLEncoder.encode(str,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String queryUrl = "http://apis.data.go.kr/6260000/BusanTblFnrstrnStusService/getTblFnrstrnStusInfo?"
                +"serviceKey="+ Key
                +"&numOfRows=10&pageNo=1"
                +"&bsnsNm="+ location;


        try {
            URL url = new URL(queryUrl);
            InputStream is = url.openStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8"));

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){

                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag=xpp.getName();

                        if(tag.equals("item"));
                        else if(tag.equals("bsnsSector")){
                            buffer.append("업종 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("bsnsCond")){
                            buffer.append("업태 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("bsnsNm")){
                            buffer.append("업소명 :");
                            xpp.next();
                            buffer.append(xpp.getText());//cpId
                            buffer.append("\n");
                        }
                        else if(tag.equals("addrRoad")){
                            buffer.append("소재지(도로명) :");
                            xpp.next();
                            buffer.append(xpp.getText());//cpNm
                            buffer.append("\n");
                        }
                        else if(tag.equals("addrJibun")){
                            buffer.append("소재지(지번) :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        else if(tag.equals("menu")){
                            buffer.append("메뉴 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        else if(tag.equals("tel")) {
                            buffer.append("전화번호 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        else if(tag.equals("specDate")) {
                            buffer.append("지정일자 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        else if(tag.equals("ovrdDate")) {
                            buffer.append("재지정일자 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        else if(tag.equals("gugun")) {
                            buffer.append("구군명 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        else if(tag.equals("dataDay")) {
                            buffer.append("데이터기준일자 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        else if(tag.equals("lat")) {
                            buffer.append("위도 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        else if(tag.equals("lng")) {
                            buffer.append("경도 :");
                            xpp.next();
                            buffer.append(xpp.getText());//
                            buffer.append("\n");
                        }
                        break;
                    case  XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName();
                        if(tag.equals("item"))buffer.append("\n");
                        break;


                }
                eventType= xpp.next();
            }
        } catch(Exception e){

        }
        buffer.append("파싱끝");
        return buffer.toString();
    }
}
