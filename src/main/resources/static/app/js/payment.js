'use strict'

$("#check_module").click(function () {
    var IMP = window.IMP; // 생략가능        
    IMP.init('import');
    // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용        
    // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드        
    IMP.request_pay({
        pg: 'inicis', // version 1.1.0부터 지원.
            /*                 
                'kakao':카카오페이,                 
                html5_inicis':이니시스(웹표준결제)                    
                'nice':나이스페이                    
                'jtnet':제이티넷                    
                'uplus':LG유플러스                    
                'danal':다날                    
                'payco':페이코                    
                'syrup':시럽페이                    
                'paypal':페이팔                
            */
        pay_method: 'card',
            /*                 
                'samsung':삼성페이,                 
                'card':신용카드,                 
                'trans':실시간계좌이체,                
                'vbank':가상계좌,                
                'phone':휴대폰소액결제             
            */            
        merchant_uid: 'merchant_' + new Date().getTime(),            
            /*                 
                merchant_uid에 경우                 
                https://docs.iamport.kr/implementation/payment                
                위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.                
                참고하세요.                 
                나중에 포스팅 해볼게요.             
            */            
        name: '주문명:결제테스트',
        //결제창에서 보여질 이름            
        amount: 1000,
        //가격             
        buyer_email: 'iamport@siot.do',            
        buyer_name: '구매자이름',            
        buyer_tel: '010-1234-5678',            
        buyer_addr: '서울특별시 강남구 삼성동',            
        buyer_postcode: '123-456',            
        m_redirect_url: 'localhost:9090/api/roundReservation/save'
            /*                  
                모바일 결제시,                
                결제가 끝나고 랜딩되는 URL을 지정                 
                (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)                
            */        
    }, function (rsp) {
        console.log(rsp);
        if (rsp.success) {                
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;                
            msg += '상점 거래ID : ' + rsp.merchant_uid;                
            msg += '결제 금액 : ' + rsp.paid_amount;                
            msg += '카드 승인번호 : ' + rsp.apply_num;            
        } else {                
            var msg = '결제에 실패하였습니다.';                
            msg += '에러내용 : ' + rsp.error_msg;            
        }            
        alert(msg);        
    });    
});

// <button id="check_module">결제하기</button>
    $("#check_module").click(function () {
    var IMP = window.IMP; // 생략가능
    IMP.init('import');
    // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
    IMP.request_pay({
    pg: 'inicis', // version 1.1.0부터 지원.
    /*
        'kakao':카카오페이,
        html5_inicis':이니시스(웹표준결제)
        'nice':나이스페이
        'jtnet':제이티넷
        'uplus':LG유플러스
        'danal':다날
        'payco':페이코
        'syrup':시럽페이
        'paypal':페이팔
    */
    pay_method: 'card',
    /*
        'samsung':삼성페이,
        'card':신용카드,
        'trans':실시간계좌이체,
        'vbank':가상계좌,
        'phone':휴대폰소액결제
    */
    merchant_uid: 'merchant_' + new Date().getTime(),
    /*
        merchant_uid에 경우
        https://docs.iamport.kr/implementation/payment
        위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
        참고하세요.
        나중에 포스팅 해볼게요.
    */
    name: '주문명:결제테스트',
    //결제창에서 보여질 이름
    amount: 100,
    //가격
    buyer_email: 'iamport@siot.do',
    buyer_name: '구매자이름',
    buyer_tel: '010-1234-5678',
    buyer_addr: '서울특별시 강남구 삼성동',
    buyer_postcode: '123-456',
    m_redirect_url: 'naver.com'
    /*
        모바일 결제시,
        결제가 끝나고 랜딩되는 URL을 지정
        (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
    */
}, function (rsp) {
    console.log(rsp);
    if (rsp.success) {
    var msg = '결제가 완료되었습니다.';

} else {
    var msg = '결제에 실패하였습니다.';
    msg += '에러내용 : ' + rsp.error_msg;
}
    alert(msg);
});
});