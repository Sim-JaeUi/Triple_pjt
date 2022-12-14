package com.project.triple.controller.page;


import com.project.triple.model.entity.User.AdminUser;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.response.*;
import com.project.triple.model.network.response.AirResponse.*;
import com.project.triple.model.network.response.CouponResponse.CouponApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingRoomApiResponse;
import com.project.triple.model.network.response.LodgingResponse.LodgingTicketApiResponse;
import com.project.triple.model.network.response.QnAResponse.QuestionApiResponse;
import com.project.triple.model.network.response.ReservationResponse.OnewayReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.ReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoomReservationApiResponse;
import com.project.triple.model.network.response.ReservationResponse.RoundTicketReservationApiResponse;
import com.project.triple.model.network.response.UserResponse.UsersApiResponse;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.model.network.response.GuideResponse.GuideReviewApiResponse;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantReviewApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotApiResponse;
import com.project.triple.model.network.response.SpotResponse.SpotReviewApiResponse;
import com.project.triple.service.*;
import com.project.triple.service.AirService.AirTicketApiLogicService;
import com.project.triple.service.AirService.AircraftApiLogicService;
import com.project.triple.service.AirService.AirlineApiLogicService;
import com.project.triple.service.AirService.AirportApiLogicService;
import com.project.triple.service.CouponService.CouponApiLogicService;
import com.project.triple.service.CouponService.UserCouponApiLogicService;
import com.project.triple.service.LodgingService.LodgingApiLogicService;
import com.project.triple.service.LodgingService.LodgingRoomApiLogicService;
import com.project.triple.service.LodgingService.LodgingTicketApiLogicService;
import com.project.triple.service.QnAService.QuestionApiLogicService;
import com.project.triple.service.ReservationService.OnewayReservationApiLogicService;
import com.project.triple.service.ReservationService.RoomReservationApiLogicService;
import com.project.triple.service.ReservationService.RoundTicketReservationApiLogicService;
import com.project.triple.service.ReservationService.ReservationApiLogicService;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.service.GuideService.GuideReviewApiLogicService;
import com.project.triple.service.RestaurantService.RestaurantReviewApiLogicService;
import com.project.triple.service.SpotService.SpotApiLogicService;
import com.project.triple.model.network.response.RestaurantResponse.RestaurantApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.service.GuideService.GuideApiLogicService;
import com.project.triple.service.MagazineApiLogicService;
import com.project.triple.service.RestaurantService.RestaurantApiLogicService;
import com.project.triple.service.SpotService.SpotReviewApiLogicService;
import com.project.triple.service.UserService.AdminUserApiLogicService;
import com.project.triple.service.UserService.UsersApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Triple")   // http://localhost:9090/Triple
public class PageController {

    @Autowired
    private LodgingApiLogicService lodgingApiLogicService;
    @Autowired
    private UsersApiLogicService usersApiLogicService;

    @Autowired
    private AirTicketApiLogicService airTicketApiLogicService;

    @Autowired
    private AdminUserApiLogicService adminUserApiLogicService;

    @Autowired
    private MagazineApiLogicService magazineApiLogicService;

    @Autowired
    private QuestionApiLogicService questionApiLogicService;

    @Autowired
    private UserCouponApiLogicService userCouponApiLogicService;

    @Autowired
    private RoundTicketReservationApiLogicService roundTicketReservationApiLogicService;

    @Autowired
    private CouponApiLogicService couponApiLogicService;

    @Autowired
    private NoticeApiLogicService noticeApiLogicService;

    @Autowired
    private RoomReservationApiLogicService roomReservationApiLogicService;

    @Autowired
    private EventApiLogicService eventApiLogicService;

    @Autowired
    private ReservationApiLogicService reservationApiLogicService;

    @Autowired
    private LodgingTicketApiLogicService lodgingTicketApiLogicService;

    @Autowired
    private TourTicketApiLogicService tourTicketApiLogicService;

    @Autowired
    private GuideApiLogicService guideApiLogicService;

    @Autowired
    private PackageApiLogicService packageApiLogicService;

    @Autowired
    private FaqApiLogicService faqApiLogicService;

    @Autowired
    private MysaveApiLogicService mysaveApiLogicService;



    @Autowired
    private LodgingRoomApiLogicService lodgingRoomApiLogicService;

    @Autowired
    private RestaurantApiLogicService restaurantApiLogicService;

    @Autowired
    private SpotApiLogicService spotApiLogicService;

    @Autowired
    private RestaurantReviewApiLogicService restaurantReviewApiLogicService;

    @Autowired
    private SpotReviewApiLogicService spotReviewApiLogicService;

    @Autowired
    private GuideReviewApiLogicService guideReviewApiLogicService;

    @Autowired
    private AirlineApiLogicService airlineApiLogicService;

    @Autowired
    private AircraftApiLogicService aircraftApiLogicService;

    @Autowired
    private AirportApiLogicService airportApiLogicService;

    @Autowired
    private OnewayReservationApiLogicService onewayReservationApiLogicService;

    @Autowired
    private RoundTicketReservationApiLogicService roundTicketListReservationApiLogicService;




    // ???????????????
    @RequestMapping(path={""})
    public ModelAndView index(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null) {

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("name");
        }


        List<AirportApiResponse> airportApiResponseList = airportApiLogicService.list().getData();
        List<EventApiResponse> eventApiResponseList = eventApiLogicService.search().getData();
        List<NoticeApiResponse> noticeApiResponseList = noticeApiLogicService.search().getData();

        //?????????
        List<MagazineApiResponse> tipList = magazineApiLogicService.tip().getData();
        List<MagazineApiResponse> recommendList = magazineApiLogicService.recommend().getData();
        List<MagazineApiResponse> shoppingList = magazineApiLogicService.shopping().getData();
        List<MagazineApiResponse> restaurantList = magazineApiLogicService.restaurant().getData();


        List<PackageApiResponse> guams = packageApiLogicService.sort_by_country("???/?????????").getData();
        List<PackageApiResponse> vietnams = packageApiLogicService.sort_by_country("?????????").getData();
        List<PackageApiResponse> americas = packageApiLogicService.sort_double("?????????","LA").getData();
//        List<PackageApiResponse> confirmed = packageApiLogicService.sort_by_keyword("????????????").getData();

        List<LodgingApiResponse> lodgingApiResponseList = lodgingApiLogicService.list();

        for(LodgingApiResponse lodgingApiResponse : lodgingApiResponseList){
            int cheap = lodgingApiLogicService.cheapestPrice(lodgingApiResponse);
            lodgingApiResponse.setCheapestPrice(cheap);
        }

        return new ModelAndView("/pages/main").addObject("email", email)
                .addObject("nickname", nickname).addObject("airportList", airportApiResponseList)
                .addObject("event", eventApiResponseList)
                .addObject("notice", noticeApiResponseList)
                .addObject("tipList",tipList).addObject("recommendList",recommendList)
                .addObject("shoppingList",shoppingList).addObject("restaurantList",restaurantList)
                .addObject("guams",guams).addObject("vietnams",vietnams).addObject("americas",americas)
                .addObject("lodgingList", lodgingApiResponseList);

    }
    //???????????? ?????????
    @RequestMapping(path="/join")
    public ModelAndView user_regist() {
        return new ModelAndView("/pages/join");
    }

    //??????????????????
    @RequestMapping(path="/login")
    public ModelAndView login() {
        return new ModelAndView("/pages/login");
    }

    //???????????????
    @PostMapping("/loginok")
    public ModelAndView loginOk( Model model, HttpServletResponse response, HttpServletRequest request, String email, String userpw) throws IOException {
        if(usersApiLogicService.login(email, userpw).getData() != null){
            HttpSession session = request.getSession();
            String nickname = usersApiLogicService.login(email, userpw).getData().getNickname();
            session.setAttribute("email", email);
            session.setAttribute("nickname", nickname);

            ScriptUtils.alertAndMovePage(response, "????????? ??????", "/Triple");

        }else{
            ScriptUtils.alertAndMovePage(response, "????????? ??????, ???????????? ??????????????? ?????? ??????????????????", "/Triple/login");

        }
        return null;
    }

//  ????????? ??????
    @PostMapping("/serviceOut")
    public ModelAndView serviceOut(HttpServletResponse response, HttpServletRequest request, String userpw) throws IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        UsersApiResponse users = usersApiLogicService.login(email, userpw).getData();
        if(users != null){
            usersApiLogicService.delete(users.getIdx());

            session.setAttribute("email",null);
            session.setAttribute("nickname", null);

            ScriptUtils.alertAndMovePage(response, "?????? ??????" , "/Triple");
            return null;


        }else{
            ScriptUtils.alertAndMovePage(response, "??????, ??????????????? ?????? ??????????????????","/Triple/mypage/settings/serviceOut");


            return null;

        }
    }

//  ??????????????? ????????????
    @PostMapping("/getPassword")
    public ModelAndView getPassword(HttpServletResponse response, HttpServletRequest request, String userpw) throws IOException {
        HttpSession session = request.getSession();
        String nickname = (String) session.getAttribute("nickname");
        String email = (String)session.getAttribute("email");
        UsersApiResponse users = usersApiLogicService.login(email, userpw).getData();
        if(users != null){
            Long idx = usersApiLogicService.findIdx(email);

            return new ModelAndView("/pages/mypage/mypage_settings/mypage_settings_profile").addObject("nickname", nickname)
                    .addObject("email", email).addObject("idx", idx);


        }else{
            ScriptUtils.alert(response, "??????, ??????????????? ?????? ??????????????????");
            return new ModelAndView("/pages/mypage/mypage_settings/mypage_get_password");

        }
    }

    // ????????????
    @RequestMapping("/logout")
    public ModelAndView logOut(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("email",null);
        session.setAttribute("nickname", null);
        ScriptUtils.alertAndMovePage(response, "???????????? ???????????????.","/Triple");
        return null;
    }

    //////////////////////////////////////////////////////???????????????

    //?????? ??????
    @RequestMapping(path = "/inquiryWrite")     // http://localhost:9090/Triple/inquiryWrite
    public ModelAndView inquiryWrite(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String email = null;
        String name = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            name = (String) session.getAttribute("nickname");
        }
        Long idx = usersApiLogicService.findIdx(email);

        model.addAttribute("email", (String)session.getAttribute("email"));
        model.addAttribute("nickname", (String)session.getAttribute("nickname"));

        return new ModelAndView("/pages/mypage/mypage_reserve/my_inquiry_write").addObject("email", email)
                .addObject("nickname", name).addObject("idx", idx);
    }

    // ?????? ?????????
    @RequestMapping(path = "/inquiryList")
    public ModelAndView inquiryList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String name = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            name = (String) session.getAttribute("nickname");
        }
        Long idx = usersApiLogicService.findIdx(email);

        List<QuestionApiResponse> questionApiResponseList = questionApiLogicService.search2(idx).getData();

        return new ModelAndView("/pages/mypage/mypage_reserve/my_inquiry_list").addObject("email", email)
                .addObject("nickname", name).addObject("idx", idx)
                .addObject("questionList", questionApiResponseList);

    }

    //?????? ??????
    @RequestMapping(path = "/mypage/coupon")
    public ModelAndView coupon_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        Long idx = usersApiLogicService.findIdx(email);
        Long couponId = userCouponApiLogicService.findUserId(idx);

        List<CouponApiResponse> couponApiResponseList = couponApiLogicService.search(couponId).getData();


        return new ModelAndView("/pages/mypage/mypage_coupon/coupon_main").addObject("email", email)
                .addObject("nickname", nickname).addObject("couponList", couponApiResponseList);
    }

    // ????????????
    @RequestMapping(path = "/mypage/coupon/inable")
    public ModelAndView mypage_inable_coupon(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        Long idx = usersApiLogicService.findIdx(email);
        Long couponId = userCouponApiLogicService.findUserId(idx);

        List<CouponApiResponse> couponApiResponseList = couponApiLogicService.search(couponId).getData();


        return new ModelAndView("/pages/mypage/mypage_coupon/mypage_inable_coupon").addObject("email", email)
                .addObject("nickname", nickname).addObject("couponList", couponApiResponseList);
    }


    //??????????????? ??????
    @RequestMapping(path = "/mypage")
    public ModelAndView  my_travel_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        Long idx = usersApiLogicService.findIdx(email);

        return new ModelAndView("/pages/mypage/my_travel/my_travel_main").addObject("email", email)
                .addObject("nickname", nickname);
    }


    //??????????????? ?????? ??????
    @RequestMapping(path = "/mypage/review")
    public ModelAndView review_main(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        List<SpotApiResponse> spotApiResponseList = spotApiLogicService.search().getData();
//        List<RestaurantApiResponse> restaurantApiResponseList = restaurantApiLogicService.search().getData();
//        List<GuideApiResponse> guideApiResponseList = guideApiLogicService.search().getData();

        List<SpotReviewApiResponse> spotReviewApiResponseList = spotReviewApiLogicService.findEmail(email).getData();
//        List<RestaurantReviewApiResponse> restaurantReviewApiResponseList = restaurantReviewApiLogicService.findEmail(email).getData();
//        List<GuideReviewApiResponse> guideReviewApiResponseList = guideReviewApiLogicService.findEmail(email).getData();

        return new ModelAndView("/pages/mypage/review/review_main").addObject("email", email)
                .addObject("nickname", nickname).addObject("spotReview", spotReviewApiResponseList)
                .addObject("spotList", spotApiResponseList);
    }

    //??????????????? ?????? ?????????
    @RequestMapping(path = "/mypage/review/guide")
    public ModelAndView review_guide(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

//        List<SpotApiResponse> spotApiResponseList = spotApiLogicService.search().getData();
//        List<RestaurantApiResponse> restaurantApiResponseList = restaurantApiLogicService.search().getData();
        List<GuideApiResponse> guideApiResponseList = guideApiLogicService.search().getData();

//        List<SpotReviewApiResponse> spotReviewApiResponseList = spotReviewApiLogicService.findEmail(email).getData();
//        List<RestaurantReviewApiResponse> restaurantReviewApiResponseList = restaurantReviewApiLogicService.findEmail(email).getData();
        List<GuideReviewApiResponse> guideReviewApiResponseList = guideReviewApiLogicService.findEmail(email).getData();

        return new ModelAndView("/pages/mypage/review/review_guide").addObject("email", email)
                .addObject("nickname", nickname)
                .addObject("guideReview", guideReviewApiResponseList)
                .addObject("guideList", guideApiResponseList);
    }

    //??????????????? ?????? ??????
    @RequestMapping(path = "/mypage/review/restaurant")
    public ModelAndView review_restaurant(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

//        List<SpotApiResponse> spotApiResponseList = spotApiLogicService.search().getData();
        List<RestaurantApiResponse> restaurantApiResponseList = restaurantApiLogicService.search().getData();
//        List<GuideApiResponse> guideApiResponseList = guideApiLogicService.search().getData();


//        List<SpotReviewApiResponse> spotReviewApiResponseList = spotReviewApiLogicService.findEmail(email).getData();
        List<RestaurantReviewApiResponse> restaurantReviewApiResponseList = restaurantReviewApiLogicService.findEmail(email).getData();
//        List<GuideReviewApiResponse> guideReviewApiResponseList = guideReviewApiLogicService.findEmail(email).getData();

        return new ModelAndView("/pages/mypage/review/review_restaurant").addObject("email", email)
                .addObject("nickname", nickname)
                .addObject("restaurantReview", restaurantReviewApiResponseList)
                .addObject("restaurantList", restaurantApiResponseList);
    }
    //??????????????? ??????
    @RequestMapping(path = "/mypage/settings")
    public ModelAndView mypage_settings(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            UsersApiResponse usersApiResponse = usersApiLogicService.findEmail(email);
            nickname = usersApiResponse.getNickname();
            session.setAttribute("nickname",nickname);
        }

        return new ModelAndView("/pages/mypage/mypage_settings/mypage_settings").addObject("email", email)
                .addObject("nickname", nickname);
    }

    // ??????????????? ????????????
    @RequestMapping(path="/mypage/settings/getPassword")
    public ModelAndView mypage_get_password(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            UsersApiResponse usersApiResponse = usersApiLogicService.findEmail(email);
            nickname = usersApiResponse.getNickname();
            session.setAttribute("nickname",nickname);
        }

        Long idx = usersApiLogicService.findIdx(email);


        return new ModelAndView("/pages/mypage/mypage_settings/mypage_get_password").addObject("email", email)
                .addObject("nickname", nickname).addObject("idx", idx);
    }

    //??????????????? ?????? ????????? ??? ?????? ??????
    @RequestMapping(path="mypage/settings/getPassword/profile")
    public ModelAndView mypage_settings_profile(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            UsersApiResponse usersApiResponse = usersApiLogicService.findEmail(email);
            nickname = usersApiResponse.getNickname();
            session.setAttribute("nickname",nickname);
        }

        Long idx = usersApiLogicService.findIdx(email);
        UsersApiResponse usersApiResponse = usersApiLogicService.read(idx).getData();


        return new ModelAndView("/pages/mypage/mypage_settings/mypage_settings_profile").addObject("email", email)
                .addObject("nickname", nickname).addObject("idx", idx).addObject("users",usersApiResponse);
    }

    //??????????????? ?????? ????????? ??????
    @RequestMapping(path="mypage/settings/serviceOut")
    public ModelAndView mypage_service_out(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long idx = usersApiLogicService.findIdx(email);


        return new ModelAndView("/pages/mypage/mypage_settings/mypage_service_out").addObject("email", email)
                .addObject("nickname", nickname).addObject("idx", idx);
    }



    //??????????????? ????????????
    @RequestMapping(path = "/mypage/settings/notice")
    public ModelAndView mypage_notice(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        List<NoticeApiResponse> noticeApiResponseList = noticeApiLogicService.search().getData();

        return new ModelAndView("/pages/mypage/mypage_settings/mypage_notice").addObject("email", email)
                .addObject("nickname", nickname).addObject("noticeList", noticeApiResponseList);
    }

    //??????????????? ???????????? ??????
    @RequestMapping(path = "/mypage/settings/notice/view/{idx}")
    public ModelAndView mypage_notice_view(@PathVariable Long idx, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        NoticeApiResponse noticeApiResponse = noticeApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/mypage/mypage_settings/mypage_notice_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("notice", noticeApiResponse);
    }

    //??????????????? ?????? ????????????
    @RequestMapping(path = "/mypage/settings/customer")
    public ModelAndView mypage_customer_help(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        List<FaqApiResponse> faqApiResponseList = faqApiLogicService.search().getData();
//        FaqApiResponse faqApiResponse = faqApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/mypage/mypage_settings/mypage_customer_help").addObject("email", email)
                .addObject("nickname", nickname).addObject("faqList", faqApiResponseList);
    }

    //??????????????? ?????? ???????????? faq
    @RequestMapping(path = "/mypage/settings/customer/faq")
    public ModelAndView mypage_FAQ_list(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        List<FaqApiResponse> faqApiResponseList = faqApiLogicService.search().getData();
//        FaqApiResponse faqApiResponse = faqApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/mypage/mypage_settings/mypage_FAQ_list").addObject("email", email)
                .addObject("nickname", nickname).addObject("faqList", faqApiResponseList);
    }

    @RequestMapping(path = "/mypage/settings/customer/faq/air")
    public ModelAndView mypage_FAQ_air(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        List<FaqApiResponse> faqApiResponseList = faqApiLogicService.AIR().getData();

        return new ModelAndView("/pages/mypage/mypage_settings/mypage_FAQ_air").addObject("email", email)
                .addObject("nickname", nickname).addObject("faqList", faqApiResponseList);
    }

    @RequestMapping(path = "/mypage/settings/customer/faq/lodging")
    public ModelAndView mypage_FAQ_lodging(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }
        List<FaqApiResponse> faqApiResponseList = faqApiLogicService.LODGING().getData();

        return new ModelAndView("pages/mypage/mypage_settings/mypage_FAQ_lodging").addObject("email", email)
                .addObject("nickname", nickname).addObject("faqList", faqApiResponseList);
    }

    @RequestMapping(path = "/mypage/settings/customer/faq/tour")
    public ModelAndView mypage_FAQ_tour(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }
        List<FaqApiResponse> faqApiResponseList = faqApiLogicService.TOUR().getData();

        return new ModelAndView("pages/mypage/mypage_settings/mypage_FAQ_tour").addObject("email", email)
                .addObject("nickname", nickname).addObject("faqList", faqApiResponseList);
    }

    @RequestMapping(path = "/mypage/settings/customer/faq/service")
    public ModelAndView mypage_FAQ_service(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }
        List<FaqApiResponse> faqApiResponseList = faqApiLogicService.SERVICE().getData();

        return new ModelAndView("pages/mypage/mypage_settings/mypage_FAQ_service").addObject("email", email)
                .addObject("nickname", nickname).addObject("faqList", faqApiResponseList);
    }

    @RequestMapping(path = "/mypage/settings/customer/faq/common")
    public ModelAndView mypage_FAQ_common(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }
        List<FaqApiResponse> faqApiResponseList = faqApiLogicService.COMMON().getData();

        return new ModelAndView("pages/mypage/mypage_settings/mypage_FAQ_common").addObject("email", email)
                .addObject("nickname", nickname).addObject("faqList", faqApiResponseList);
    }

    @RequestMapping(path = "/mypage/settings/customer/faq/{idx}")
    public ModelAndView FAQ_detail(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        FaqApiResponse faqApiResponse = faqApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/mypage/mypage_settings/FAQ_detail").addObject("email", email)
                .addObject("nickname", nickname).addObject("faq", faqApiResponse);
    }



    //??????????????? ????????? ??????
    @RequestMapping(path = "/mypage/reserve/air")
    public ModelAndView my_reserve_air(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long roundDepartureTicketId = roundTicketReservationApiLogicService.findDeparture(email);
        Long combackTicketId = roundTicketReservationApiLogicService.findComeback(email);
        Long onewayDepartureTicketId = onewayReservationApiLogicService.findDeparture(email);
        AirTicketApiResponse airTicketApiResponse1 = airTicketApiLogicService.read2(roundDepartureTicketId).getData();
        AirTicketApiResponse airTicketApiResponse3 = airTicketApiLogicService.read2(combackTicketId).getData();
        AirTicketApiResponse airTicketApiResponse2 = airTicketApiLogicService.read2(onewayDepartureTicketId).getData();
        RoundTicketReservationApiResponse roundTicketReservationApiResponse = roundTicketReservationApiLogicService.read2(email).getData();
        OnewayReservationApiResponse onewayReservationApiResponse = onewayReservationApiLogicService.read2(email).getData();

//        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = roundTicketReservationApiLogicService.search3(email).getData();
//        List<OnewayReservationApiResponse> onewayReservationApiResponseList = onewayReservationApiLogicService.search3(email).getData();

        return new ModelAndView("/pages/mypage/mypage_reserve/my_reserve_air").addObject("email", email)
                .addObject("nickname", nickname).addObject("roundDepartureId", roundDepartureTicketId)
                .addObject("roundCombackId", combackTicketId).addObject("onewayDepartureId", onewayDepartureTicketId)
                .addObject("airTicketRDT", airTicketApiResponse1)
                .addObject("airTicketODT", airTicketApiResponse2)
                .addObject("airTicketRCT", airTicketApiResponse3)
                .addObject("roundData", roundTicketReservationApiResponse)
                .addObject("onewayData", onewayReservationApiResponse);
    }

    //??????????????? ????????? ??????
    @RequestMapping(path = "/mypage/reserve/lodging")
    public ModelAndView my_reserve_lodging(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        List<RoomReservationApiResponse> roomReservationApiResponseList = roomReservationApiLogicService.search(email).getData();
        List<LodgingRoomApiResponse> lodgingRoomApiResponseList = lodgingRoomApiLogicService.search().getData();
        List<LodgingApiResponse> lodgingApiResponseList = lodgingApiLogicService.search().getData();

        return new ModelAndView("/pages/mypage/mypage_reserve/my_reserve_lodging").addObject("email", email)
                .addObject("nickname", nickname).addObject("roomReservation", roomReservationApiResponseList)
                .addObject("lodgingRoom", lodgingRoomApiResponseList).addObject("lodging", lodgingApiResponseList);
    }

    //??????????????? ????????? ????????????
    @RequestMapping(path = "/mypage/reserve/tour")
    public ModelAndView my_reserve_tourTicket(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        List<ReservationApiResponse> reservationApiResponseList = reservationApiLogicService.tour().getData();


        return new ModelAndView("/pages/mypage/mypage_reserve/my_reserve_tourTicket").addObject("email", email)
                .addObject("nickname", nickname).addObject("reserveList", reservationApiResponseList);
    }

    //????????? ?????? view ??????
    @RequestMapping(path = "/mypage/reserve/air/round/{idx}")
    public ModelAndView my_reserve_air_round(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        String business = "business";
        String economy = "economy";
        String first = "first";
        String premium = "premium";

        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long roundDepartureTicketId = roundTicketReservationApiLogicService.findDeparture(email);
        Long combackTicketId = roundTicketReservationApiLogicService.findComeback(email);
        AirTicketApiResponse airTicketApiResponse1 = airTicketApiLogicService.read2(roundDepartureTicketId).getData();
        AirTicketApiResponse airTicketApiResponse3 = airTicketApiLogicService.read2(combackTicketId).getData();
        RoundTicketReservationApiResponse roundTicketReservationApiResponse = roundTicketReservationApiLogicService.read2(email).getData();
        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = roundTicketReservationApiLogicService.search(email).getData();
        String dAirport = airTicketApiLogicService.findDepartureAirport(roundDepartureTicketId);
        String lAirport = airTicketApiLogicService.findLandingAirport(roundDepartureTicketId);

        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList1 = roundTicketReservationApiLogicService.list5().getData();

        String city1 = airportApiLogicService.findCity(dAirport);
        String city2 = airportApiLogicService.findCity(lAirport);

        UsersApiResponse usersApiResponse = usersApiLogicService.read2(email).getData();

        Long businessClass = roundTicketReservationApiLogicService.classCount(business);
        Long economyClass = roundTicketReservationApiLogicService.classCount(economy);
        Long firstClass = roundTicketReservationApiLogicService.classCount(first);
        Long premiumClass = roundTicketReservationApiLogicService.classCount(premium);

        return new ModelAndView("/pages/mypage/mypage_reserve/my_airplane_reserve_round").addObject("email", email)
                .addObject("nickname", nickname).addObject("roundDepartureId", roundDepartureTicketId)
                .addObject("roundCombackId", combackTicketId)
                .addObject("airTicketRDT", airTicketApiResponse1)
                .addObject("airTicketRCT", airTicketApiResponse3)
                .addObject("roundData", roundTicketReservationApiResponse)
                .addObject("roundList", roundTicketReservationApiResponseList)
                .addObject("city1", city1)
                .addObject("city2", city2)
                .addObject("users", usersApiResponse).addObject("business", businessClass)
                .addObject("economy", economyClass).addObject("first", firstClass)
                .addObject("premium", premiumClass).addObject("roundLL", roundTicketReservationApiResponseList1);
    }

    //????????? ?????? view ??????
    @RequestMapping(path = "/mypage/reserve/air/oneway/{idx}")
    public ModelAndView my_reserve_air_oneway(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        String business = "business";
        String economy = "economy";
        String first = "first";
        String premium = "premium";

        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long onewayDepartureTicketId = onewayReservationApiLogicService.findDeparture(email);
        AirTicketApiResponse airTicketApiResponse2 = airTicketApiLogicService.read2(onewayDepartureTicketId).getData();
        OnewayReservationApiResponse onewayReservationApiResponse = onewayReservationApiLogicService.read2(email).getData();
        List<OnewayReservationApiResponse> onewayReservationApiResponseList = onewayReservationApiLogicService.search(email).getData();

        String dAirport = airTicketApiLogicService.findDepartureAirport(onewayDepartureTicketId);
        String lAirport = airTicketApiLogicService.findLandingAirport(onewayDepartureTicketId);

        String city1 = airportApiLogicService.findCity(dAirport);
        String city2 = airportApiLogicService.findCity(lAirport);

        UsersApiResponse usersApiResponse = usersApiLogicService.read2(email).getData();

        Long businessClass = onewayReservationApiLogicService.classCount(business);
        Long economyClass = onewayReservationApiLogicService.classCount(economy);
        Long firstClass = onewayReservationApiLogicService.classCount(first);
        Long premiumClass = onewayReservationApiLogicService.classCount(premium);

        return new ModelAndView("/pages/mypage/mypage_reserve/my_airplane_reserve_oneway").addObject("email", email)
                .addObject("nickname", nickname)
                .addObject("onewayDepartureId", onewayDepartureTicketId)
                .addObject("airTicketODT", airTicketApiResponse2)
                .addObject("onewayData", onewayReservationApiResponse)
                .addObject("onewayList", onewayReservationApiResponseList)
                .addObject("city1", city1)
                .addObject("city2", city2)
                .addObject("users", usersApiResponse).addObject("business", businessClass)
                .addObject("economy", economyClass).addObject("first", firstClass)
                .addObject("premium", premiumClass);
    }
//    @PostMapping("/serviceOut")
//    public ModelAndView serviceOut(HttpServletResponse response, HttpServletRequest request, String userpw) throws IOException {
//        HttpSession session = request.getSession();
//        String email = (String)session.getAttribute("email");
//        UsersApiResponse users = usersApiLogicService.login(email, userpw).getData();
//        if(users != null){
//            usersApiLogicService.delete(users.getIdx());
//
//            session.setAttribute("email",null);
//            session.setAttribute("nickname", null);
//
//            ScriptUtils.alert(response, "?????? ??????" );
//            return new ModelAndView("/pages/main");
//
//
//        }else{
//            ScriptUtils.alert(response, "??????, ??????????????? ?????? ??????????????????");
//            return new ModelAndView("/pages/login");
//
//        }
//    }
    //????????? ?????? ?????? ??????
    @RequestMapping(path = "/mypage/reserve/air/round/cancle/{idx}")
    public ModelAndView my_reserve_air_cancle(@PathVariable Long idx, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        String adultCount = "??????";
        String childCount = "??????";
        String infantCount = "??????";
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }


        Long roundDepartureTicketId = roundTicketReservationApiLogicService.findDeparture(email);
        Long combackTicketId = roundTicketReservationApiLogicService.findComeback(email);
        AirTicketApiResponse airTicketApiResponse1 = airTicketApiLogicService.read2(roundDepartureTicketId).getData();
        AirTicketApiResponse airTicketApiResponse3 = airTicketApiLogicService.read2(combackTicketId).getData();
        RoundTicketReservationApiResponse roundTicketReservationApiResponse = roundTicketReservationApiLogicService.read2(email).getData();
        List<RoundTicketReservationApiResponse> roundTicketReservationApiResponseList = roundTicketReservationApiLogicService.search(email).getData();
        String dAirport = airTicketApiLogicService.findDepartureAirport(roundDepartureTicketId);
        String lAirport = airTicketApiLogicService.findLandingAirport(roundDepartureTicketId);

        String city1 = airportApiLogicService.findCity(dAirport);
        String city2 = airportApiLogicService.findCity(lAirport);

        UsersApiResponse usersApiResponse = usersApiLogicService.read2(email).getData();




        return new ModelAndView("/pages/mypage/mypage_reserve/my_airplane_reserve_round_cancle").addObject("email", email)
                .addObject("nickname", nickname).addObject("roundDepartureId", roundDepartureTicketId)
                .addObject("roundCombackId", combackTicketId)
                .addObject("airTicketRDT", airTicketApiResponse1)
                .addObject("airTicketRCT", airTicketApiResponse3)
                .addObject("roundData", roundTicketReservationApiResponse)
                .addObject("roundList", roundTicketReservationApiResponseList)
                .addObject("city1", city1)
                .addObject("city2", city2)
                .addObject("users", usersApiResponse);
    }

    //????????? ?????? view
    @RequestMapping(path = "/mypage/reserve/lodging/{idx}")
    public ModelAndView my_reserve_lodging(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        RoomReservationApiResponse roomReservationApiResponse = roomReservationApiLogicService.read2(idx).getData();
        List<LodgingRoomApiResponse> lodgingRoomApiResponseList = lodgingRoomApiLogicService.search().getData();
        List<LodgingApiResponse> lodgingApiResponseList = lodgingApiLogicService.search().getData();
        UsersApiResponse usersApiResponse = usersApiLogicService.read2(email).getData();

        return new ModelAndView("/pages/mypage/mypage_reserve/my_room_reserve").addObject("email", email)
                .addObject("nickname", nickname).addObject("roomReservation", roomReservationApiResponse)
                .addObject("lodgingRoom", lodgingRoomApiResponseList).addObject("lodging", lodgingApiResponseList)
                .addObject("user" , usersApiResponse);
    }

    //????????? ?????? ??????
    @RequestMapping(path = "/mypage/reserve/lodging/cancle/{ticketNum}")
    public ModelAndView my_reserve_lodging_cancle(@PathVariable String ticketNum, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        LodgingTicketApiResponse lodgingTicketApiResponse = lodgingTicketApiLogicService.read2(ticketNum).getData();


        return new ModelAndView("/pages/mypage/mypage_reserve/my_room_reserve").addObject("email", email)
                .addObject("nickname", nickname).addObject("lodgingTicket", lodgingTicketApiResponse);
    }

//    //????????? ?????? view
//    @RequestMapping(path = "/mypage/reserve/tour/view/{idx}")
//    public ModelAndView my_reserve_tourTicket(@PathVariable Long idx, HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String nickname = null;
//        if (session == null) {
//
//        } else {
//            email = (String) session.getAttribute("email");
//            nickname = (String) session.getAttribute("nickname");
//        }
//
//        ReservationApiResponse reservationApiResponse = reservationApiLogicService.read(idx).getData();
//
//        return new ModelAndView("/pages/mypage/mypage_reserve/my_reserve_tourTicket").addObject("email", email)
//                .addObject("nickname", nickname).addObject("reserve", reservationApiResponse);
//    }


//        Long idx = usersApiLogicService.findIdx(email);
//        String ticketNum = reservationApiLogicService.findTicketNum(idx);
//        String tNum = tourTicketApiLogicService.findAllTicketNum(ticketNum);
//
//        List<TourTicketApiResponse> tourTicketApiResponseList = tourTicketApiLogicService.search2(tNum).getData();
//
//        return new ModelAndView("/pages/mypage/mypage_reserve/my_reserve_tourTicket").addObject("email", email)
//                .addObject("nickname", nickname).addObject("reserveTourList", tourTicketApiResponseList);
//    }

    @RequestMapping(path = "/mypage/travels")
    public ModelAndView travels_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long idx = usersApiLogicService.findIdx(email);

        return new ModelAndView("/pages/mypage/travels/travels_done").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/mypage/mysave")
    public ModelAndView my_save_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long idx = usersApiLogicService.findIdx(email);
        List<MysaveApiResponse> mysaveApiResponseList = mysaveApiLogicService.search(idx).getData();


        return new ModelAndView("/pages/mypage/mysave/my_save_main").addObject("email", email)
                .addObject("nickname", nickname).addObject("mysaveList", mysaveApiResponseList);

    }

    @RequestMapping(path= "mypage/mysave/guide")
    public ModelAndView my_save_guide(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long idx = usersApiLogicService.findIdx(email);
        List<MysaveApiResponse> mysaveApiResponseList = mysaveApiLogicService.guide(idx).getData();

        return new ModelAndView("/pages/mypage/mysave/my_save_guide").addObject("email", email)
                .addObject("nickname", nickname).addObject("mysaveList", mysaveApiResponseList);
    }

    @RequestMapping(path= "mypage/mysave/spot")
    public ModelAndView my_save_spot(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long idx = usersApiLogicService.findIdx(email);
        List<MysaveApiResponse> mysaveApiResponseList = mysaveApiLogicService.spot(idx).getData();

        return new ModelAndView("/pages/mypage/mysave/my_save_spot").addObject("email", email)
                .addObject("nickname", nickname).addObject("mysaveList", mysaveApiResponseList);
    }

    @RequestMapping(path= "mypage/mysave/restaurant")
    public ModelAndView my_save_restaurant(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long idx = usersApiLogicService.findIdx(email);
        List<MysaveApiResponse> mysaveApiResponseList = mysaveApiLogicService.restaurant(idx).getData();

        return new ModelAndView("/pages/mypage/mysave/my_save_restaurant").addObject("email", email)
                .addObject("nickname", nickname).addObject("mysaveList", mysaveApiResponseList);
    }

    @RequestMapping(path= "mypage/mysave/lodging")
    public ModelAndView my_save_lodging(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long idx = usersApiLogicService.findIdx(email);
        List<MysaveApiResponse> mysaveApiResponseList = mysaveApiLogicService.lodging(idx).getData();

        return new ModelAndView("/pages/mypage/mysave/my_save_lodging").addObject("email", email)
                .addObject("nickname", nickname).addObject("mysaveList", mysaveApiResponseList);
    }

    @RequestMapping(path= "mypage/mysave/tour")
    public ModelAndView my_save_tour(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if (session == null) {

        } else {
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }

        Long idx = usersApiLogicService.findIdx(email);
        List<MysaveApiResponse> mysaveApiResponseList = mysaveApiLogicService.tour(idx).getData();

        return new ModelAndView("/pages/mypage/mysave/my_save_tour").addObject("email", email)
                .addObject("nickname", nickname).addObject("mysaveList", mysaveApiResponseList);
    }


//    @RequestMapping(path = "/magazine/recommend")   //http://localhost:9090/Triple/magazine_recommend
//    public ModelAndView magazine_recommend(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String nickname = null;
//        if(session == null){
//
//        }else{
//            email = (String)session.getAttribute("email");
//            nickname = (String)session.getAttribute("nickname");
//        }
//
//        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.recommend().getData();
//
//        return new ModelAndView("/pages/magazine/magazine_recommend").addObject("email", email)
//                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
//    }

    //////////////////////////////////////////////////////??????????????? ???

    //??????
//    @RequestMapping(path = "/flightMain")       //http://localhost:9090/Triple/flightMain
//    public ModelAndView flightMain(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String nickname = null;
//        if(session == null){
//
//        }else{
//            email = (String)session.getAttribute("email");
//            nickname = (String)session.getAttribute("nickname");
//        }
//
//        return new ModelAndView("/pages/flight_reservation/flight_main").addObject("email", email)
//                .addObject("nickname", nickname);
//    }



    @RequestMapping(path = "/flightList")   //http://localhost:9090/Triple/flightList
    public ModelAndView flightList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }


        return new ModelAndView("/pages/flight_reservation/flight_list").addObject("email", email)
                .addObject("name", nickname);
    }



    @RequestMapping(path = "/flightMain")
    public ModelAndView flightMain(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<AirTicketApiResponse> domesticList = airTicketApiLogicService.find_by_route("??????").getData();
        List<AirTicketApiResponse> overseasList = airTicketApiLogicService.find_by_route("??????").getData();
        List<AirportApiResponse> airportApiResponseList = airportApiLogicService.list().getData();

        return new ModelAndView("/pages/flight_reservation/flight_main").addObject("email", email)
                .addObject("nickname", nickname).addObject("oversasList", overseasList).addObject("domesticList", domesticList).addObject("airportList", airportApiResponseList);
    }


    @RequestMapping(path = "/flightReservation" )
    public ModelAndView flightReservation(AirReservationInfo airReservationInfo , HttpServletRequest request, HttpServletResponse response)throws IOException {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){
            ScriptUtils.alertAndMovePage(response, "????????? ??? ???????????????","/Triple/login");
        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        Integer ChildNum = 0;
        Integer AdultNum = 0;
        Integer InfantNum = 0;
        ChildNum = airReservationInfo.getChild();
        AdultNum = airReservationInfo.getAdult();
        InfantNum = airReservationInfo.getInfant();
        Integer total = ChildNum + AdultNum + InfantNum;
        List<TicketCounting> ticketCountingList = new ArrayList<>();
        Long i = 1L;
        while(i <= total){

            for(int j = 0 ; j < AdultNum; j++){
                TicketCounting ticketcnt = new TicketCounting();
                ticketcnt.setId(i);
                ticketcnt.setAgeType("??????");
                ticketCountingList.add(ticketcnt);
                i++;
            }
            for(int k = 0; k < ChildNum; k++){
                TicketCounting ticketcnt = new TicketCounting();
                ticketcnt.setId(i);
                ticketcnt.setAgeType("??????");
                ticketCountingList.add(ticketcnt);
                i++;
            }
            for(int j = 0 ; j < InfantNum; j++){
                TicketCounting ticketcnt = new TicketCounting();
                ticketcnt.setId(i);
                ticketcnt.setAgeType("??????");
                ticketCountingList.add(ticketcnt);
                i++;
            }
        }
        return new ModelAndView("/pages/flight_reservation/flight_reservation").addObject("email",email)
                .addObject("nickname", nickname).addObject("seatClass", airReservationInfo.getSeatClass())
                .addObject("departureFlight", airTicketApiLogicService.read(airReservationInfo.getDepartureFlight()).getData())
                .addObject("comebackFlight" , airTicketApiLogicService.read(airReservationInfo.getComebackFlight()).getData())
                .addObject("countList", ticketCountingList).addObject("childNum", ChildNum).addObject("adultNum",AdultNum)
                .addObject("infantNum", InfantNum);
    }

    @RequestMapping(path = "/flightReservation/oneway" )
    public ModelAndView flightReservation_oneway(AirReservationInfo airReservationInfo , HttpServletRequest request, HttpServletResponse response)throws IOException {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){
            ScriptUtils.alertAndMovePage(response, "????????? ??? ???????????????","/Triple/login");
        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        Integer ChildNum = 0;
        Integer AdultNum = 0;
        Integer InfantNum = 0;
        ChildNum = airReservationInfo.getChild();
        AdultNum = airReservationInfo.getAdult();
        InfantNum = airReservationInfo.getInfant();
        Integer total = ChildNum + AdultNum + InfantNum;
        List<TicketCounting> ticketCountingList = new ArrayList<>();
        Long i = 1L;
        while(i <= total){

            for(int j = 0 ; j < AdultNum; j++){
                TicketCounting ticketcnt = new TicketCounting();
                ticketcnt.setId(i);
                ticketcnt.setAgeType("??????");
                ticketCountingList.add(ticketcnt);
                i++;
            }
            for(int k = 0; k < ChildNum; k++){
                TicketCounting ticketcnt = new TicketCounting();
                ticketcnt.setId(i);
                ticketcnt.setAgeType("??????");
                ticketCountingList.add(ticketcnt);
                i++;
            }
            for(int j = 0 ; j < InfantNum; j++){
                TicketCounting ticketcnt = new TicketCounting();
                ticketcnt.setId(i);
                ticketcnt.setAgeType("??????");
                ticketCountingList.add(ticketcnt);
                i++;
            }
        }
        return new ModelAndView("/pages/flight_reservation/flight_reservation_one_way").addObject("email",email)
                .addObject("nickname", nickname).addObject("seatClass", airReservationInfo.getSeatClass())
                .addObject("departureFlight", airTicketApiLogicService.read(airReservationInfo.getDepartureFlight()).getData())
                .addObject("countList", ticketCountingList).addObject("childNum", ChildNum).addObject("adultNum",AdultNum)
                .addObject("infantNum", InfantNum);
    }

//    @RequestMapping(path = "/flightView/oneway/{id}")
//    public ModelAndView flightView_oneway(@PathVariable Long id, HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String nickname = null;
//        if(session == null){
//
//        }else{
//            email = (String)session.getAttribute("email");
//            nickname = (String)session.getAttribute("nickname");
//        }
//
//        AirTicketApiResponse airTicketApiResponse = airTicketApiLogicService.read(id).getData();
//
//        return new ModelAndView("/pages/flight_reservation/flight_view").addObject("email",email)
//                .addObject("nickname", nickname).addObject("airTicket", airTicketApiResponse);
//    }
//    @RequestMapping(path = "/flightView/round")
//    public ModelAndView flightView_round( HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String nickname = null;
//        if(session == null){
//
//        }else{
//            email = (String)session.getAttribute("email");
//            nickname = (String)session.getAttribute("nickname");
//        }
//
////        AirTicketApiResponse airTicketApiResponse1 = airTicketApiLogicService.read(id1).getData();
////        AirTicketApiResponse airTicketApiResponse2 = airTicketApiLogicService.read(id2).getData();
//
//        return new ModelAndView("/pages/flight_reservation/flight_view_round").addObject("email",email);
//                .addObject("nickname", nickname).addObject("departureTicket", airTicketApiResponse1)
//                .addObject("landingTicket", airTicketApiResponse2);
//    }



    //magazine
    @RequestMapping(path = "/magazine")     //http://localhost:9090/Triple/magazine
    public ModelAndView magazine(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.list().getData();

        return new ModelAndView("/pages/magazine/magazine").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }

    @RequestMapping(path = "/magazine/recommend/view/{idx}")   //http://localhost:9090/Triple/magazine_recommend
    public ModelAndView magazine_recommend_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/recommend_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/tip/view/{idx}")     //http://localhost:9090/Triple/magazine_tip
    public ModelAndView magazine_tip_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/tip_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/restaurant/view/{idx}")    //http://localhost:9090/Triple/magazine_eatplace
    public ModelAndView magazine_restaurant_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/eatplace_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/air/view/{idx}")     //http://localhost:9090/Triple/magazine_airport
    public ModelAndView magazine_air_view(@PathVariable Long idx,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/airport_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/lodging/view/{idx}")      //http://localhost:9090/Triple/magazine_guesthouse
    public ModelAndView magazine_lodging_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/guesthouse_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/tourticket/view/{idx}")      //http://localhost:9090/Triple/magazine_tourticket/view/{idx}
    public ModelAndView magazine_tourticket_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/tourticket_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/shopping/view/{idx}")        //http://localhost:9090/Triple/magazine_shop
    public ModelAndView magazine_shopping_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/shop_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/travels/view/{idx}")     //http://localhost:9090/Triple/magazine_travels
    public ModelAndView magazine_travels_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/magazine/magazine_view/travels_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }

    @RequestMapping(path = "/magazine/recommend")   //http://localhost:9090/Triple/magazine_recommend
    public ModelAndView magazine_recommend(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.recommend().getData();

        return new ModelAndView("/pages/magazine/magazine_recommend").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }

    @RequestMapping(path = "/magazine/travels")   //http://localhost:9090/Triple/magazine_recommend
    public ModelAndView magazine_travels(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.recommend().getData();

        return new ModelAndView("/pages/magazine/magazine_travels").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }

    @RequestMapping(path = "/magazine/tip")     //http://localhost:9090/Triple/magazine_tip
    public ModelAndView magazine_tip(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.tip().getData();

        return new ModelAndView("/pages/magazine/magazine_tip").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/restaurant")    //http://localhost:9090/Triple/magazine_eatplace
    public ModelAndView magazine_restaurant(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.restaurant().getData();

        return new ModelAndView("/pages/magazine/magazine_eatplace").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/air")     //http://localhost:9090/Triple/magazine_airport
    public ModelAndView magazine_air(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.air().getData();

        return new ModelAndView("/pages/magazine/magazine_airport").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/lodging")      //http://localhost:9090/Triple/magazine_guesthouse
    public ModelAndView magazine_lodging(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.lodging().getData();

        return new ModelAndView("/pages/magazine/magazine_guesthouse").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/tourticket")      //http://localhost:9090/Triple/magazine_tourticket
    public ModelAndView magazine_tourticket(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.tourTicket().getData();

        return new ModelAndView("/pages/magazine/magazine_tourticket").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/shopping")        //http://localhost:9090/Triple/magazine_shop
    public ModelAndView magazine_shopping(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.shopping().getData();

        return new ModelAndView("/pages/magazine/magazine_shop").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }






    //?????? ??????
    @RequestMapping(path = "/spot_tour")
    public ModelAndView spot_tour(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }



        return new ModelAndView("/pages/travel_spot/spot_tour").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_tour_info")
    public ModelAndView spot_tour_info(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_tour_info").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_review")          //http://localhost:9090/Triple/spot_review
    public ModelAndView spot_review(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("spot_review_restaurant").addObject("email", email)
                .addObject("nickname", nickname);
    }




//    //?????? ?????? ?????????
//    @RequestMapping(path = "/spot_restaurant_info")
//    public ModelAndView spot_restaurant_info(HttpServletRequest request){
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String nickname = null;
//        if(session == null){
//
//        }else{
//            email = (String)session.getAttribute("email");
//            nickname = (String)session.getAttribute("nickname");
//        }
//
//        Long idx = usersApiLogicService.findIdx(email);
//
//        return new ModelAndView("/pages/travel_spot/spot_restaurant_info").addObject("email", email)
//                .addObject("nickname", nickname).addObject("userId", idx);
//    }

    //?????? ??????
    @RequestMapping(path = "/spot_overseas")            //http://localhost:9090/Triple/spot_overseas
    public ModelAndView spot_overseas(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_overseas").addObject("email", email)
                .addObject("nickname", nickname);
    }

    //????????? ?????? ?????????
   @RequestMapping(path = "/spot_location/view/{id}/{page}")      //http://localhost:9090/Triple/spot_location_info/{id}
    public ModelAndView spot_guide_info(HttpServletRequest request, @PathVariable Long id, @PathVariable Long page){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        Long userId = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
            userId = usersApiLogicService.findIdx(email);
        }


        GuideApiResponse guide = guideApiLogicService.read(id).getData();
        Long guideIdx = guide.getIdx();
        List<GuideReviewApiResponse> guideReviewApiResponseList = guideReviewApiLogicService.findReview(guideIdx).getData();
       Integer totalElement = guide.getReviewCount();
       Integer totalpage = (totalElement / 10 + 1);
       List<Integer> pageNum = new ArrayList<>();
       for(int i = 1 ; i <= totalpage ; i ++){
           pageNum.add(i);
       }
       List<GuideReviewApiResponse> reviewList = new ArrayList<>();
       if(guideReviewApiResponseList.size() <= 10){
           reviewList = guideReviewApiResponseList;
       }else {
           if (page == 1) {
               int startIndex = 0;
               int endIndex = 10;
               reviewList = guideReviewApiResponseList.subList(startIndex, endIndex);
           } else {
               int startIndex = 0;
               int endIndex = 0;
               if(guideReviewApiResponseList.size() <= page*10) {
                   startIndex = (int) (page - 1) * 10;
                   endIndex = totalElement;

               }else{
                   startIndex = (int)(page - 1) * 10;
                   endIndex = (int)(page*10);

               }
               reviewList = guideReviewApiResponseList.subList(startIndex, endIndex);
           }
       }

        return new ModelAndView("/pages/travel_spot/spot_location_info").addObject("email", email)
                .addObject("nickname", nickname).addObject("guide", guide).addObject("reviewList", reviewList)
                .addObject("pageList", pageNum).addObject("userId", userId);

    }

    //????????? ?????? ??????
    @RequestMapping(path = "/spot/location/review_delete/{id}/{id2}")      //http://localhost:9090/Triple/spot_location_info/{id}
    public ModelAndView spot_location_review_delete(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id, @PathVariable Long id2) throws IOException{
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        guideReviewApiLogicService.delete2(id, id2);


        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/spot_location/view/" + id2 + "/1");
        return null;
    }

    // ?????? ?????? ??????
    @RequestMapping(path = "/spot/restaurant/review_delete/{id}/{id2}")      //http://localhost:9090/Triple/spot_location_info/{id}
    public ModelAndView spot_restaurnat_review_delete(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id, @PathVariable Long id2) throws IOException{
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        restaurantReviewApiLogicService.delete2(id, id2);


        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/spot/restaurant/view/"+id2+"/1");
        return null;
    }



    //????????? ?????????
    @RequestMapping(path = "/spot_location")        //http://localhost:9090/Triple/spot_location
    public ModelAndView spot_guide(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<GuideApiResponse> guideApiResponseList = guideApiLogicService.list().getData();


        return new ModelAndView("/pages/travel_spot/spot_location").addObject("email", email)
                .addObject("nickname", nickname).addObject("guideList",guideApiResponseList);
    }

    // ?????? ??????
    @RequestMapping(path = "/spot_domestic")
    public ModelAndView spot_domestic(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_domestic").addObject("email", email)
                .addObject("nickname", nickname);
    }




    /* ????????? ????????? */
    /* ????????? ????????? ?????????*/
    @RequestMapping(path={"/adminUser"})        //http://localhost:9090/Triple/adminUser
    public ModelAndView admin_main(HttpServletResponse response, HttpServletRequest request) throws IOException{
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        String email = null;
        if(session == null) {
            ScriptUtils.alertAndMovePage(response, "????????? ????????? ??? ???????????????", "/Triple/admin/admin_login");
        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        List<UsersApiResponse> usersList = usersApiLogicService.search().getData();
        //Long idx = usersApiLogicService.findIdx(email);
        //List<QuestionApiResponse> questionApiResponseList = questionApiLogicService.search2(idx).getData();
    //    List<AdminUserApiResponse> adminUserList = AdminUserApiLogicService.search().getData();
        List<QuestionApiResponse> inquiryList = questionApiLogicService.search().getData();

        return new ModelAndView("/pages/admin/admin_main")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("users", usersList)
//                .addObject("question", questionApiResponseList)
//                .addObject("email",email)
//                .addObject("idx",idx);
                .addObject("inquiry",inquiryList);

    }
    @RequestMapping(path="/admin/admin_login")      //http://localhost:9090/Triple/admin/admin_login
    public ModelAndView admin_login() {
        return new ModelAndView("/pages/admin/admin_login");
    }

    /* ????????? ?????? */
    @RequestMapping(path="/admin/admin_join")       //http://localhost:9090/Triple/admin/admin_join
    public ModelAndView admin_join() {
        return new ModelAndView("/pages/admin/manage/admin_manage_register");
    }

    /* ????????? ?????? */
    @PostMapping("/admin_loginOk")      //http://localhost:9090/Triple/admin/admin_loginOk
    public ModelAndView admin_loginOk(HttpServletResponse response, HttpServletRequest request, String userid, String userpw) throws IOException {

        if(adminUserApiLogicService.admin_login(userid, userpw).getData() != null){
            HttpSession session = request.getSession();
            String name = adminUserApiLogicService.admin_login(userid, userpw).getData().getName();
            session.setAttribute("userid", userid);
            session.setAttribute("userpw", userpw);
            session.setAttribute("name", name);

            ScriptUtils.alertAndMovePage(response, "????????? ??????", "/Triple/adminUser");
//            return new ModelAndView("/pages/admin/admin_main").addObject("userid", userid)
//                    .addObject("name", name);

        }else{
            ScriptUtils.alert(response, "????????? ??????, ???????????? ??????????????? ?????? ??????????????????");
            return new ModelAndView("/pages/admin/admin_login");
        }
        return null;
    }

    /* ????????? ???????????? */
    @RequestMapping("/admin/logout")
    public ModelAndView admin_logout(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("userid",null);
        session.setAttribute("name", null);
        ScriptUtils.alert(response, "???????????? ???????????????.");
        return new ModelAndView("/pages/admin/admin_login");
    }

    /*????????? ?????????*/
    @RequestMapping(path = "/adminList")   //http://localhost:9090/Triple/adminList
    public ModelAndView adminList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<AdminUserApiResponse> adminUserList = adminUserApiLogicService.search().getData();
        //        List<TimeCollector> timeTakenList = adminUserList.stream().map(adminUserApiResponse ->
        //                adminUserApiLogicService.timeSort(adminUserApiResponse)
        //        ).collect(Collectors.toList());

        return new ModelAndView("/pages/admin/manage/admin_manage_list").addObject("userid", userid)
                .addObject("name", name).addObject("adminUserList", adminUserList);
    }

    /* ????????? ???????????? ????????? */
    @RequestMapping(path="/adminList/view/{idx}")       //http://localhost:9090/Triple/adminList/view/{idx}
    public ModelAndView adminList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        AdminUserApiResponse adminUserApiResponse = adminUserApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/manage/admin_manage_detail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("adminUser", adminUserApiResponse);
    }
    /* ????????? ?????? */
    @RequestMapping(path="/adminList/delete/{idx}")        //http://localhost:9090/Triple/adminList/delete/{idx}
    public ModelAndView adminListDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header adminUserApiResponse = adminUserApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/adminList");
        return null;

    }

    /* ???????????? ????????? */
    @RequestMapping(path = "/admin/noticeList")   //http://localhost:9090/Triple/admin/noticeList
    public ModelAndView noticeList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        List<NoticeApiResponse> noticeList = noticeApiLogicService.search().getData();

        return new ModelAndView("/pages/admin/notice/notice-list").addObject("userid", userid)
                .addObject("name", name).addObject("noticeList", noticeList);
    }


    /* ???????????? ?????? */
    @RequestMapping(path = "/admin/notice/register")        //http://localhost:9090/Triple/admin/notice/register
    public ModelAndView notice_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/notice/notice-register")
                .addObject("userid", userid)
                .addObject("name", name);
    }

    /* ???????????? ???????????? ????????? */
    @RequestMapping(path="/admin/noticeList/view/{idx}")       //http://localhost:9090/Triple/noticeList/view/{idx}
    public ModelAndView noticeList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        NoticeApiResponse noticeApiResponse = noticeApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/notice/notice-detail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("notice", noticeApiResponse);
    }

    /* ???????????? ?????? */
    @RequestMapping(path="/admin/noticeList/delete/{idx}")        //http://localhost:9090/Triple/noticeList/delete/{idx}
    public ModelAndView noticeListDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header noticeListApiResponse = noticeApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/admin/noticeList");
        return null;
    }

    /* ????????? ????????? */
    @RequestMapping(path = "/admin/eventList")   //http://localhost:9090/Triple/admin/eventList
    public ModelAndView eventList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        List<EventApiResponse> eventList = eventApiLogicService.search().getData();

        return new ModelAndView("/pages/admin/event/eventList").addObject("userid", userid)
                .addObject("name", name).addObject("eventList", eventList);
    }

    /* ????????? ?????? */
    @RequestMapping(path = "/admin/event/register")        //http://localhost:9090/Triple/admin/event/register
    public ModelAndView event_register(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){
            ScriptUtils.alertAndMovePage(response, "????????? ????????? ??? ???????????????", "/Triple/admin/admin_login");
        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/event/eventRegister")
                .addObject("userid", userid)
                .addObject("name", name);
    }

    /* ????????? ???????????? ????????? */
    @RequestMapping(path="/admin/eventList/view/{idx}")       //http://localhost:9090/Triple/eventList/view/{idx}
    public ModelAndView eventList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        EventApiResponse eventApiResponse = eventApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/event/eventDetail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("event", eventApiResponse);
    }

    /* ????????? ?????? */
    @RequestMapping(path="/admin/eventList/delete/{idx}")        //http://localhost:9090/Triple/eventList/delete/{idx}
    public ModelAndView eventListDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header eventListApiResponse = eventApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/admin/eventList");
        return null;
    }

    /* FAQ (?????????) ?????? */
    @RequestMapping(path = "/admin/faq/register")        //http://localhost:9090/Triple/admin/faq/register
    public ModelAndView faq_register(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){
            ScriptUtils.alertAndMovePage(response, "????????? ????????? ??? ???????????????", "/Triple/admin/admin_login");
        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/inquiry/admin_FAQ_regist")
                .addObject("userid", userid)
                .addObject("name", name);
    }


    /* FAQ (?????????) ????????? */
    @RequestMapping(path = "/admin/faqList")   //http://localhost:9090/Triple/admin/faqList
    public ModelAndView faqList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        List<FaqApiResponse> faqList = faqApiLogicService.search().getData();

        return new ModelAndView("/pages/admin/inquiry/admin_FAQ_list").addObject("userid", userid)
                .addObject("name", name).addObject("faqList", faqList);
    }

    /* faq ???????????? ????????? */
    @RequestMapping(path="/admin/faqList/view/{idx}")       //http://localhost:9090/Triple/adminList/view/{idx}
    public ModelAndView faqList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        FaqApiResponse faqApiResponse = faqApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/inquiry/admin_FAQ_detail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("faq", faqApiResponse);
    }

    /* faq ?????? */
    @RequestMapping(path="/admin/faqList/delete/{idx}")        //http://localhost:9090/Triple/faqList/delete/{idx}
    public ModelAndView faqListDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header faqListApiResponse = faqApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/admin/faqList");
        return null;
    }

    /* faq ?????? */
    @RequestMapping(path="/admin/faqList/modify/{idx}")       //http://localhost:9090/Triple/adminList/view/{idx}
    public ModelAndView faqList_modify(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        FaqApiResponse faqApiResponse = faqApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/inquiry/admin_FAQ_adjust")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("faq", faqApiResponse);
    }

    /* ?????? ?????? > ?????? ?????? */
    @RequestMapping(path="/admin/userList")      //http://localhost:9090/Triple/admin/userList
    public ModelAndView admin_userList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<UsersApiResponse> userList = usersApiLogicService.search().getData();
        return new ModelAndView("/pages/admin/member/memberlist")
                .addObject("userid", userid)
                .addObject("name", name).addObject("userList", userList);
    }
    /* ?????? ???????????? ????????? */
    @RequestMapping(path="/admin/userList/view/{idx}")       //http://localhost:9090/Triple/admin/userList/view/{idx}
    public ModelAndView admin_userList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        UsersApiResponse usersApiResponse = usersApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/member/memberinfo")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("users", usersApiResponse);
    }

    /* ?????? ?????? > ?????? ?????? */
    @RequestMapping(path="/admin/user/term")      //http://localhost:9090/Triple/admin/user/term
    public ModelAndView admin_userTerm() {
        return new ModelAndView("/pages/admin/member/memberSign-up");
    }

    /* ?????? ?????? > ????????? */
    @RequestMapping(path="/admin/booking/fly")      //http://localhost:9090/Triple/admin/booking/fly
    public ModelAndView admin_booking_fly(HttpServletRequest request) throws NullPointerException {

        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<RoundTicketReservationApiResponse> roundTicketList = roundTicketListReservationApiLogicService.search2().getData();
        return new ModelAndView("/pages/admin/booking/fly_reservation")
                .addObject("userid", userid)
                .addObject("name", name).addObject("roundTicketList", roundTicketList);
    }

    /* ?????? ?????? > ????????? > ???????????? */
    @RequestMapping(path="/admin/booking/fly/view/{idx}")       //http://localhost:9090/Triple/admin/booking/fly/view/{idx}
    public ModelAndView booking_fly_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        RoundTicketReservationApiResponse roundTicketReservationApiResponse = roundTicketReservationApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/booking/flyDetail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("roundTicket", roundTicketReservationApiResponse);
    }

    /* ?????? ?????? > ?????? */
    @RequestMapping(path="/admin/booking/lodging")      //http://localhost:9090/Triple/admin/booking/lodging
    public ModelAndView admin_booking_lodging() {
        return new ModelAndView("/pages/admin/booking/room_resevation");
    }

    /* ?????? ?????? > ????????? */
    @RequestMapping(path="/admin/booking/package")      //http://localhost:9090/Triple/admin/booking/package
    public ModelAndView admin_booking_package() {
        return new ModelAndView("/pages/admin/booking/package_reservation");
    }

    /* ?????? ?????? > ?????? */
    @RequestMapping(path="/admin/booking/ticket")      //http://localhost:9090/Triple/admin/booking/ticket
    public ModelAndView admin_booking_ticket() {
        return new ModelAndView("/pages/admin/booking/ticket_reservation");
    }

    /* ?????? ?????? > ????????? ?????? */
    @RequestMapping(path="/airportList")      //http://localhost:9090/Triple/airportList
    public ModelAndView admin_airportList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }

        List<AirportApiResponse> airportList = airportApiLogicService.search().getData();

        return new ModelAndView("/pages/admin/NewRegistration/destinationList")
                .addObject("userid", userid)
                .addObject("name", name).addObject("airportList", airportList);
    }

    /* ?????? ?????? > ????????? */
    @RequestMapping(path="/admin/airLineList")      //http://localhost:9090/Triple/admin/airLineList
    public ModelAndView admin_airLineList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<AirTicketApiResponse> airTicketList = airTicketApiLogicService.search_sort().getData();
        return new ModelAndView("/pages/admin/productlist/admin_productlist_airline")
                .addObject("userid", userid)
                .addObject("name", name).addObject("airTicketList", airTicketList);
    }

    /* ?????? ?????? > ?????? */
    @RequestMapping(path="/admin/lodgingList")      //http://localhost:9090/Triple/admin/lodgingList
    public ModelAndView admin_lodgingList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<LodgingApiResponse> lodgingList = lodgingApiLogicService.search().getData();
        return new ModelAndView("/pages/admin/productlist/admin_productlist_lodging")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("lodgingList", lodgingList);
    }
    /* ?????? ?????? > ?????? */
    @RequestMapping(path="/admin/lodgingRoomList")      //http://localhost:9090/Triple/admin/lodgingList
    public ModelAndView admin_lodgingRoomList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<LodgingRoomApiResponse> lodgingRoomList = lodgingRoomApiLogicService.search().getData();
        return new ModelAndView("/pages/admin/productlist/admin_productlist_lodgingRoom")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("lodgingRoomList", lodgingRoomList);
    }

    /* ?????? ?????? > ?????? > ?????? */
    @RequestMapping(path="/admin/lodgingList/view/{idx}")       //http://localhost:9090/Triple/admin/booking/fly/view/{idx}
    public ModelAndView lodgingList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){
        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        LodgingApiResponse lodgingApiResponse = lodgingApiLogicService.read(idx).getData();
        List<LodgingRoomApiResponse> lodgingRoomList = lodgingRoomApiLogicService.search().getData();
        return new ModelAndView("/pages/admin/productlist/admin_productlist_lodgingRoom")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("lodging", lodgingApiResponse)
                .addObject("lodgingRoomList", lodgingRoomList);
    }
    /* ?????? ?????? > ?????? ???????????? */
    @RequestMapping(path="/admin/lodgingRoomList/view/{idx}")       //http://localhost:9090/Triple/admin/lodgingRoomList/view/{idx}
    public ModelAndView lodgingRoomList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){
        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        LodgingRoomApiResponse lodgingRoomApiResponse = lodgingRoomApiLogicService.read(idx).getData();
        LodgingApiResponse lodgingApiResponse = lodgingApiLogicService.read(lodgingRoomApiResponse.getCompanyId()).getData();
        return new ModelAndView("/pages/admin/productlist/admin_productlist_lodgingRoom_detail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("lodging", lodgingApiResponse)
                .addObject("lodgingRoom", lodgingRoomApiResponse);
    }
    /* ?????? ?????? */
    @RequestMapping(path="/admin/lodgingRoomList/delete/{idx}")        //http://localhost:9090/Triple/admin/lodgingRoom/delete/{idx}
    public ModelAndView lodgingRoomDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header lodgingRoomApiResponse = lodgingRoomApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/admin/lodgingList");
        return null;
    }


    /* ?????? ?????? > ????????? */
    @RequestMapping(path="/admin/packageList")      //http://localhost:9090/Triple/admin/packageList
    public ModelAndView admin_packageList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<PackageApiResponse> packageList = packageApiLogicService.search().getData();
        return new ModelAndView("/pages/admin/productlist/admin_productlist_package")
                .addObject("userid", userid)
                .addObject("name", name).addObject("packageList", packageList);
    }
    /* ?????? > ?????? */
    @RequestMapping(path="/admin/couponList")      //http://localhost:9090/Triple/admin/couponList
    public ModelAndView admin_couponList() {
        return new ModelAndView("/pages/admin/coupon/couponList");
    }

    /* ?????? > ?????? */
    @RequestMapping(path="/admin/coupon/register")      //http://localhost:9090/Triple/admin/coupon/register
    public ModelAndView admin_coupon_register() {
        return new ModelAndView("/pages/admin/coupon/couponRegistration");
    }

    /* ????????? > ?????? */
    @RequestMapping(path="/admin/magazineList")      //http://localhost:9090/Triple/admin/magazineList
    public ModelAndView admin_magazineList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<MagazineApiResponse> magazineList = magazineApiLogicService.search().getData();
        return new ModelAndView("/pages/admin/magazine/magazine-list")
                .addObject("userid", userid)
                .addObject("name", name).addObject("magazineList", magazineList);
    }

    /* ????????? ???????????? */
    @RequestMapping(path="/admin/magazineList/view/{idx}")       //http://localhost:9090/Triple/admin/magazineList/view/{idx}
    public ModelAndView magazineList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/magazine/magazine-detail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("magazine", magazineApiResponse);
    }

    /* ????????? ?????? */
    @RequestMapping(path="/admin/magazineList/delete/{idx}")        //http://localhost:9090/Triple/admin/magazineList/delete/{idx}
    public ModelAndView magazineListDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header magazineApiResponse = magazineApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/admin/magazineList");
        return null;
    }

    /* ???????????? > ?????? */
    @RequestMapping(path="/admin/spotList")      //http://localhost:9090/Triple/admin/spotList
    public ModelAndView admin_spotList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<SpotApiResponse> spotList = spotApiLogicService.search().getData(); //??????
        List<GuideApiResponse> guideList = guideApiLogicService.search().getData(); //?????????
        List<RestaurantApiResponse> restaurantList = restaurantApiLogicService.search().getData(); //??????
        return new ModelAndView("/pages/admin/spot/spotList")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("spotList", spotList)
                .addObject("guideList", guideList)
                .addObject("restaurantList", restaurantList);
    }

    /* ???????????? > ????????? ????????????(?????????) */
    @RequestMapping(path="/admin/spotList/view/{idx}")       ///admin/spotList/view/{idx}"
    public ModelAndView guide_view_default(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        GuideApiResponse guideApiResponse = guideApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/spot/spot_guideDetail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("guide", guideApiResponse);
    }
    /* ????????? ?????? */
    @RequestMapping(path="/admin/spotList/guide/delete/{idx}")        //http://localhost:9090/Triple/admin/spotList/guide/delete/{idx}
    public ModelAndView guideListDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header guideListApiResponse = guideApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/admin/spotList");
        return null;
    }

    /* ???????????? > ????????? ???????????? */
    @RequestMapping(path="/admin/spotList/guide2_table/view/{idx}")       ///admin/spotList/view/{idx}"
    public ModelAndView guide_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        GuideApiResponse guideApiResponse = guideApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/spot/spot_guideDetail2")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("guide", guideApiResponse);
    }

    /* ???????????? > ?????? ???????????? */
    @RequestMapping(path="/admin/spotList/tour_table/view/{idx}")       ///admin/spotList/view/{idx}"
    public ModelAndView tour_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        SpotApiResponse tourApiResponse = spotApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/spot/spot_tourismDetail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("tour", tourApiResponse);
    }
    /* ?????? ?????? */
    @RequestMapping(path="/admin/spotList/tour/delete/{idx}")        //http://localhost:9090/Triple/admin/spotList/guide/delete/{idx}
    public ModelAndView tourListDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header tourListApiResponse = spotApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/admin/spotList");
        return null;
    }

    /* ???????????? > ?????? ???????????? */
    @RequestMapping(path="/admin/spotList/restaurant_table/view/{idx}")       ///admin/spotList/view/{idx}"
    public ModelAndView restaurant_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        RestaurantApiResponse restaurantApiResponse = restaurantApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/spot/spot_restaurantDetail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("restaurant", restaurantApiResponse);
    }

    /* ?????? ?????? */
    @RequestMapping(path="/admin/spotList/restaurant/delete/{idx}")        //http://localhost:9090/Triple/admin/spotList/guide/delete/{idx}
    public ModelAndView restaurantListDelete(HttpServletResponse response, @PathVariable Long idx) throws IOException{
        Header restaurantListApiResponse = restaurantApiLogicService.delete(idx);
        ScriptUtils.alertAndMovePage(response,"?????????????????????", "/Triple/admin/spotList");
        return null;
    }

    /* ?????? */
    @RequestMapping(path="/admin/payment")      //http://localhost:9090/Triple/admin/payment
    public ModelAndView admin_payment() {
        return new ModelAndView("/pages/admin/payment/payment");
    }

    /* 1:1 ?????? */
    @RequestMapping(path="/admin/inquiryList")      //http://localhost:9090/Triple/admin/inquiryList
    public ModelAndView admin_inquiryList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;

        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<QuestionApiResponse> inquiryList = questionApiLogicService.search().getData();

        return new ModelAndView("/pages/admin/inquiry/admin_inquiry_list")
                .addObject("email", email)
                .addObject("nickname", nickname).addObject("inquiryList",inquiryList);
    }

    /* 1:1 ?????? ?????? */
    @RequestMapping(path="/admin/inquiry/view/{idx}")       //http://localhost:9090/Triple/adminList/view/{idx}
    public ModelAndView admin_inquiryView(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        QuestionApiResponse inquiry = questionApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/admin/inquiry/admin_inquiry_detail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("inquiry", inquiry);
    }



    // ?????????????????? ????????? ??????
    @RequestMapping(path = "/admin/magazine_register")      //http://localhost:9090/Triple/admin/magazine_register
    public ModelAndView magazine_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/magazine/magazine-register").addObject("userid", userid)
                .addObject("name", name);
    }

    //????????? ??????
    @RequestMapping(path = "/package_register")         //http://localhost:9090/Triple/package_register
    public ModelAndView package_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/product/packge").addObject("userid", userid)
                .addObject("name", name);
    }

    //????????? ??????
    @RequestMapping(path = "/package")          //http://localhost:9090/Triple/package
    public ModelAndView package_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }


        List<PackageApiResponse> guams = packageApiLogicService.sort_by_country("???/?????????").getData();
        List<PackageApiResponse> vietnams = packageApiLogicService.sort_by_country("?????????").getData();
        List<PackageApiResponse> Singapores = packageApiLogicService.sort_by_country("????????????").getData();
        List<PackageApiResponse> Italys = packageApiLogicService.sort_by_country("????????????").getData();
        List<PackageApiResponse> americas = packageApiLogicService.sort_double("?????????","LA").getData();
        List<PackageApiResponse> confirmed = packageApiLogicService.sort_by_keyword("????????????").getData();


        return new ModelAndView("/pages/travel_package/package_main").addObject("email", email)
                .addObject("nickname", nickname).addObject("guams", guams).addObject("vietnams",vietnams)
                .addObject("Singapores", Singapores).addObject("Italys", Italys).addObject("americas", americas)
                .addObject("confirmedList",confirmed);
    }

    @RequestMapping(path = "/package/america")          //http://localhost:9090/Triple/package/america
    public ModelAndView package_america(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_package/package_america").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/package/eastsouthasia")        //http://localhost:9090/Triple/package/eastsouthasia
    public ModelAndView package_eastsouthasia(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_package/package_eastsouthasia").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/package/europe")               //http://localhost:9090/Triple/package/europe
    public ModelAndView package_europe(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_package/package_europe").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/package/japan")            //http://localhost:9090/Triple/package/japan
    public ModelAndView package_japan(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_package/package_japan").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/package/southpacific")         //http://localhost:9090/Triple/package/southpacific
    public ModelAndView package_southpacific(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_package/package_america").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/package/specialprice")     //http://localhost:9090/Triple/package/specialprice
    public ModelAndView package_specialprice(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_package/package_america").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/package/view/{idx}")      //http://localhost:9090/Triple/package/view/{idx}
    public ModelAndView package_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        PackageApiResponse packageApiResponse = packageApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/travel_package/package_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("package", packageApiResponse);
    }


    //?????? ??????
    @RequestMapping(path = "/restaurant_register")      //http://localhost:9090/Triple/restaurant_register
    public ModelAndView restaurant_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/spot/spot_restaurant").addObject("userid", userid)
                .addObject("name", name);
    }

    @RequestMapping(path = "/spot/restaurant")      //http://localhost:9090/Triple/package/view/
    public ModelAndView restaurant_list( HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<RestaurantApiResponse> restaurantApiResponseList = restaurantApiLogicService.list().getData();

        return new ModelAndView("/pages/travel_spot/spot_restaurant_list").addObject("email", email)
                .addObject("nickname", nickname).addObject("restaurantList", restaurantApiResponseList);
    }

    @RequestMapping(path = "/spot/restaurant/view/{idx}/{page}")      //http://localhost:9090/Triple/package/view/
    public ModelAndView restaurant_view(@PathVariable Long idx,@PathVariable Long page, HttpServletRequest request ,HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        Long userId = null;
        if(session == null){

        }else{
                email = (String) session.getAttribute("email");
                nickname = (String) session.getAttribute("nickname");
                userId = usersApiLogicService.findIdx(email);
        }


        RestaurantApiResponse restaurantApiResponse = restaurantApiLogicService.read(idx).getData();
        Long restaurantId = restaurantApiResponse.getIdx();
        List<RestaurantReviewApiResponse> restaurantReviewApiResponseList = restaurantReviewApiLogicService.findReview(restaurantId).getData();
        //?????????
        Integer totalElement = restaurantApiResponse.getReviewCount();
        Integer totalpage = (totalElement / 10 + 1);
        List<Integer> pageNum = new ArrayList<>();
        for(int i = 1 ; i <= totalpage ; i ++){
            pageNum.add(i);
        }
        List<RestaurantReviewApiResponse> reviewList = new ArrayList<>();
        if(restaurantReviewApiResponseList.size() <= 10){
            reviewList = restaurantReviewApiResponseList;
        }else {
            if (page == 1) {
                int startIndex = 0;
                int endIndex = 10;
                reviewList = restaurantReviewApiResponseList.subList(startIndex, endIndex);
            } else {
                int startIndex = 0;
                int endIndex = 0;
                if(restaurantReviewApiResponseList.size() <= page*10) {
                    startIndex = (int) (page - 1) * 10;
                    endIndex = totalElement;

                }else{
                    startIndex = (int)(page - 1) * 10;
                    endIndex = (int)(page*10);

                }
                reviewList = restaurantReviewApiResponseList.subList(startIndex, endIndex);
            }
        }

        return new ModelAndView("/pages/travel_spot/spot_restaurant_info").addObject("email", email)
                .addObject("nickname", nickname).addObject("restaurant", restaurantApiResponse)
                .addObject("reviewList",reviewList).addObject("pageList", pageNum)
                .addObject("userId", userId);
    }

    @RequestMapping(path = "/tourism_register")
    public ModelAndView tourism_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/spot/spot_tourism").addObject("userid", userid)
                .addObject("name", name);
    }

    @RequestMapping(path = "/spot/tour")
    public ModelAndView tour_list(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        List<SpotApiResponse> spotApiResponseList = spotApiLogicService.list().getData();

        return new ModelAndView("/pages/travel_spot/spot_tour").addObject("userid", userid)
                .addObject("name", name).addObject("tourList" , spotApiResponseList);
    }

    @RequestMapping(path = "/spot/tour/view/{id}")
    public ModelAndView tour_view(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)throws IOException{
        HttpSession session = request.getSession(false);
        String nickname = null;
        String email = null;
        Long userId = null;
        if(session == null){

        }else{
            nickname = (String)session.getAttribute("name");
            email = (String) session.getAttribute("email");
            userId = usersApiLogicService.findIdx(email);
        }
        SpotApiResponse spotApiResponse = spotApiLogicService.read(id).getData();
        Long tourId = spotApiResponse.getIdx();
        List<SpotReviewApiResponse> spotReviewApiResponses = spotReviewApiLogicService.findReview(tourId).getData();

        return new ModelAndView("/pages/travel_spot/spot_tour_info").addObject("email", email)
                .addObject("nickname", nickname).addObject("tour" , spotApiResponse)
                .addObject("reviewList", spotReviewApiResponses).addObject("userId", userId);
    }

    //????????? ??????
    @RequestMapping(path = "/guide_register")
    public ModelAndView guide_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/spot/spot_guide").addObject("userid", userid)
                .addObject("name", name);
    }

    //?????? ?????? ?????????
    @RequestMapping(path = "/spot/review/{kind}/{id}")
    public ModelAndView spot_review(@PathVariable String kind, @PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){
            ScriptUtils.alertAndMovePage( response,"????????? ??? ???????????????", "/Triple/login");
        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        if(email==null || nickname==null){
            ScriptUtils.alertAndMovePage( response,"????????? ??? ???????????????", "/Triple/login");
        }

        if(kind.equals("restaurant")){

            return new ModelAndView("/pages/travel_spot/spot_review_restaurant").addObject("email", email)
                    .addObject("nickname", nickname).addObject("kind", kind).addObject("postId", id);
        }
        if(kind.equals("guide")){
            return new ModelAndView("/pages/travel_spot/spot_review_guide").addObject("email", email)
                    .addObject("nickname", nickname).addObject("kind", kind).addObject("postId", id);
        }
        if(kind.equals("tour")){
            return new ModelAndView("/pages/travel_spot/spot_review_tour").addObject("email", email)
                    .addObject("nickname", nickname).addObject("kind", kind).addObject("postId", id);
        }
        else{
            ScriptUtils.alertAndMovePage(response, "????????? ???????????????", "/Triple");
            return null;
        }
    }


    @RequestMapping(path = "/spot/review_update/{kind}/{id}")
    public ModelAndView spot_review_update(@PathVariable String kind, @PathVariable Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){
            ScriptUtils.alertAndMovePage( response,"????????? ??? ???????????????", "/Triple/login");
        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        if(email==null || nickname==null){
            ScriptUtils.alertAndMovePage( response,"????????? ??? ???????????????", "/Triple/login");
        }

        if(kind.equals("restaurant")){

            return new ModelAndView("/pages/travel_spot/spot_review_update_restaurant").addObject("email", email)
                    .addObject("nickname", nickname).addObject("kind", kind).addObject("review", restaurantReviewApiLogicService.read(id).getData());
        }
        if(kind.equals("guide")){

            return new ModelAndView("/pages/travel_spot/spot_review_update_guide").addObject("email", email)
                    .addObject("nickname", nickname).addObject("kind", kind).addObject("review", guideReviewApiLogicService.read(id).getData())
                    ;
        }
        if(kind.equals("tour")){
            return new ModelAndView("/pages/travel_spot/spot_review_update_tour").addObject("email", email)
                    .addObject("nickname", nickname).addObject("kind", kind).addObject("reviewId", id);
        }
        else{
            ScriptUtils.alertAndMovePage(response, "????????? ???????????????", "/Triple");
            return null;
        }
    }

    //????????? ????????? ?????????
    @RequestMapping(path = "/event")
    public ModelAndView event_main( HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

            List<EventApiResponse> eventList = eventApiLogicService.search().getData();

        return new ModelAndView("/pages/event/event_main").addObject("email", email)
                .addObject("nickname", nickname).addObject("eventList", eventList);
    }
    /* ????????? > ???????????? */
    @RequestMapping(path="/eventList/view/{idx}")       //http://localhost:9090/Triple/eventList/view/{idx}
    public ModelAndView user_eventList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
//        EventApiResponse eventApiResponse = eventApiLogicService.read(idx).getData();
        EventApiResponse eventApiResponse = eventApiLogicService.read2(idx).getData();
        return new ModelAndView("/pages/event/event_view")
                .addObject("email", email)
                .addObject("nickname", nickname)
                .addObject("event", eventApiResponse);
    }

    //????????? ??????
    @RequestMapping(path = "/aircraft_register")
    public ModelAndView aircraft_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        List<AirlineApiResponse>  airlineApiResponseList = airlineApiLogicService.list().getData();

        return new ModelAndView("/pages/admin/NewRegistration/aircraftRegist").addObject("userid", userid)
                .addObject("name", name).addObject("airlineList", airlineApiResponseList);
    }

    //????????? ??????
    @RequestMapping(path = "/airline_register")
    public ModelAndView airline_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/NewRegistration/airlineRegist").addObject("userid", userid)
                .addObject("name", name);
    }

    //????????? ??????
    @RequestMapping(path = "/destination_register")
    public ModelAndView destination_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/NewRegistration/destinationRegist").addObject("userid", userid)
                .addObject("name", name);
    }

    //????????? ???????????? ????????? ??????
    @RequestMapping(path = "/airline_select")
    public ModelAndView airline_select(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        List<AirlineApiResponse> airlineApiResponseList = airlineApiLogicService.list().getData();

        return new ModelAndView("/pages/admin/product/airline_select").addObject("userid", userid)
                .addObject("name", name).addObject("airlineList", airlineApiResponseList);
    }

    //????????? ??????
   @RequestMapping(path = "/air_register/{airlineName}")
    public ModelAndView air_register(@PathVariable String airlineName, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

            List<AircraftApiResponse> aircraftApiResponseList = aircraftApiLogicService.search_by_name(airlineName).getData();
            List<AirportApiResponse> airportApiResponseList = airportApiLogicService.list().getData();

        return new ModelAndView("/pages/admin/product/air").addObject("userid", userid)
                .addObject("name", name).addObject("aircraftList", aircraftApiResponseList).addObject("airportList", airportApiResponseList);

    }

    //???????????? ??????
    @RequestMapping(path = "/tour_ticket_main")
    public ModelAndView tour_ticket( HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }


        return new ModelAndView("/pages/tour_ticket/tour_ticket_main").addObject("email", email)
                .addObject("nickname", nickname);
    }

    //???????????? ?????????
    @RequestMapping(path = "/tour_ticket_calendar")
    public ModelAndView tour_ticket_calendar( HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }


        return new ModelAndView("/pages/tour_ticket/tourticket_calendar").addObject("email", email)
                .addObject("nickname", nickname);
    }

    //???????????? ??????
    @RequestMapping(path = "/tour_ticket_view")
    public ModelAndView tour_ticket_view( HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }


        return new ModelAndView("/pages/tour_ticket/tourticket_view").addObject("email", email)
                .addObject("nickname", nickname);
    }

    //???????????? ??????
    @RequestMapping(path = "/tour_ticket_reservation")
    public ModelAndView tour_ticket_reservation( HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }


        return new ModelAndView("/pages/tour_ticket/tourticket_Reservation").addObject("email", email)
                .addObject("nickname", nickname);
    }

    /* ??????????????? ?????? > ???????????? */
    @RequestMapping(path="/mypage/settings/info/company")      //http://localhost:9090/Triple/mypage/settings/info/company
    public ModelAndView info_company() {
        return new ModelAndView("/pages/mypage/mypage_settings/info/mypage_info_company");
    }
    /* ??????????????? ?????? > ???????????? ???????????? */
    @RequestMapping(path="/mypage/settings/info/user")      //http://localhost:9090/Triple/mypage/settings/info/user
    public ModelAndView info_user() {
        return new ModelAndView("/pages/mypage/mypage_settings/info/mypage_info_user");
    }
    /* ??????????????? ?????? > ????????? ???????????? */
    @RequestMapping(path="/mypage/settings/info/service")      //http://localhost:9090/Triple/mypage/settings/info/service
    public ModelAndView info_service() {
        return new ModelAndView("/pages/mypage/mypage_settings/info/mypage_info_term_service");
    }

    /* ??????????????? ?????? > ???????????? ???????????? */
    @RequestMapping(path="/mypage/settings/info/map")      //http://localhost:9090/Triple/mypage/settings/info/map
    public ModelAndView info_map() {
        return new ModelAndView("/pages/mypage/mypage_settings/info/mypage_info_term_map");
    }

    /* ??????????????? ?????? > ????????? ?????? ??????????????? */
    @RequestMapping(path="/mypage/settings/info/partner")      //http://localhost:9090/Triple/mypage/settings/info/partner
    public ModelAndView info_partner() {
        return new ModelAndView("/pages/mypage/mypage_settings/info/mypage_info_item_partner");
    }

    /* ??????????????? ?????? > ???????????? ???????????? */
    @RequestMapping(path="/mypage/settings/info/openSource")      //http://localhost:9090/Triple/mypage/settings/info/b
    public ModelAndView info_openSource() {
        return new ModelAndView("/pages/mypage/mypage_settings/info/mypage_info_open_source");
    }

    //?????? ?????? ??????
    @RequestMapping(path="/lodging_main")
    public ModelAndView lodging_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }


        return new ModelAndView("/pages/lodging_room/lodging_main").addObject("email", email)
                .addObject("nickname", nickname);
    }


    @RequestMapping(path="/lodging_company_list")
    public ModelAndView lodging_list(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<LodgingApiResponse> lodgingApiResponseList = lodgingApiLogicService.list();
        for(LodgingApiResponse lodgingApiResponse : lodgingApiResponseList){
            int cheap = lodgingApiLogicService.cheapestPrice(lodgingApiResponse);
            lodgingApiResponse.setCheapestPrice(cheap);
        }

        return new ModelAndView("/pages/lodging_room/lodging_list").addObject("email", email)
                .addObject("nickname", nickname).addObject("lodgingList", lodgingApiResponseList);
    }

    @RequestMapping(path = "/lodging_view/{id}")
    public ModelAndView lodging_view(HttpServletRequest request, @PathVariable Long id){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        LodgingApiResponse lodgingApiResponse = lodgingApiLogicService.read(id).getData();
        lodgingApiResponse.setCheapestPrice(lodgingApiLogicService.cheapestPrice(lodgingApiResponse));
        List<LodgingRoomApiResponse> lodgingRoomApiResponseList = lodgingRoomApiLogicService.same_company(id);


        return new ModelAndView("/pages/lodging_room/lodging_roomlist").addObject("email", email)
                .addObject("nickname", nickname).addObject("roomList",lodgingRoomApiResponseList).addObject("lodging", lodgingApiResponse);
    }

    @RequestMapping(path="/lodging_company")
    public ModelAndView lodging_company(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }


        return new ModelAndView("/pages/admin/NewRegistration/lodgingCompany").addObject("userid", userid)
                .addObject("name", name);
    }

    @RequestMapping(path="/room_register")
    public ModelAndView room_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        List<LodgingApiResponse> lodgingApiResponseList = lodgingApiLogicService.list();


        return new ModelAndView("/pages/admin/product/room").addObject("userid", userid)
                .addObject("name", name).addObject("companyList", lodgingApiResponseList);
    }

    @RequestMapping(path = "/room_view/{id}")
    public ModelAndView room_view(HttpServletRequest request, @PathVariable Long id){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        LodgingRoomApiResponse lodgingRoomApiResponse = lodgingRoomApiLogicService.read(id).getData();
        LodgingApiResponse lodgingApiResponse = lodgingApiLogicService.read(lodgingRoomApiResponse.getCompanyId()).getData();

        return new ModelAndView("/pages/lodging_room/lodging_roominfo").addObject("email", email)
                .addObject("nickname", nickname).addObject("room", lodgingRoomApiResponse).addObject("lodging",lodgingApiResponse);
    }

    @RequestMapping(path = "/lodging_reservation")
    public ModelAndView room_reservation(HttpServletRequest request, HttpServletResponse response, String startDate, String endDate, Long roomId)throws IOException{
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){
            ScriptUtils.alertAndMovePage(response, "????????? ??? ???????????????", "/Triple/login");
        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        LodgingRoomApiResponse lodgingRoomApiResponse = lodgingRoomApiLogicService.read(roomId).getData();
        LodgingApiResponse lodgingApiResponse = lodgingApiLogicService.read(lodgingRoomApiResponse.getCompanyId()).getData();
        Period period = Period.between(LocalDate.parse(startDate), LocalDate.parse(endDate));


        return new ModelAndView("/pages/lodging_room/lodging_reservation").addObject("roomInfo", lodgingRoomApiResponse).addObject("start", startDate).addObject("end",endDate)
                .addObject("lodging",lodgingApiResponse).addObject("period", period.getDays());
    }
}
