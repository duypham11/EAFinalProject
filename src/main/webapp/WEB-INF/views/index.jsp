
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<tiles:insertDefinition name="customerLayout">
	<tiles:putAttribute name="title">Promotion and Announcement</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-4">
				<div class="panel panel-primary">
					<div class="panel-heading">Message from FlashDelivery CEO</div>
					<div class="panel-body">
						<p>
							Thanks for choosing FlashDelivery as your delivery service. We,
							at FlashDelivery, are committed to serve you with the best
							industry customer service of at least 90% customer satisfaction
							rating. Should you have any feedback, please kindly let us know.<br>
							<br>Warm Regards,<br> <br> Camilo

						</p>
					</div>
					<div class="panel-footer">Feedback ...</div>
				</div>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<div class="panel panel-primary">
					<div class="panel-heading">New Sign up Promotion</div>
					<div class="panel-body">
						<p>We are growing larger and larger mainly Thanks to your
							support.Starting 2018, any new sign up as our partner, there will
							be a special promotion of NO delivery charge for the first 6
							months. Interested ?</p>
					</div>
					<div class="panel-footer">sign up now ...</div>
				</div>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<div class="panel panel-red">
					<div class="panel-heading">Free Dinning Coupon</div>
					<div class="panel-body">
						<p>Panda store just opens in your neighbourhood. Visit
							the store with coupon code: PandaAwesome2017, you will be
							entitled for 50% off for dinner cost more than $50. T&C Applys</p>
					</div>
					<div class="panel-footer">more detail..</div>
				</div>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Announcements</div>
					<!-- .panel-heading -->
					<div class="panel-body">
						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseOne">New Sign up Rider</a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in">
									<div class="panel-body">With regard to new law and
										regular imposed by Trump administration, all new sign up
										riders must have a valid driving licence which will not expire
										in the next 6 months of sign up date.</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseTwo">New Sign up Rider Latest Development</a>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse">
									<div class="panel-body">With regard to law and regular
										imposed by Trump administration, all new sign up rider no
										longer need a valid driving licence which will not expire in
										the next 6 months of sign up date.</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseThree">Announcement #3</a>
									</h4>
								</div>
								<div id="collapseThree" class="panel-collapse collapse">
									<div class="panel-body">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit, sed do eiusmod tempor incididunt
										ut labore et dolore magna aliqua. Ut enim ad minim veniam,
										quis nostrud exercitation ullamco laboris nisi ut aliquip ex
										ea commodo consequat. Duis aute irure dolor in reprehenderit
										in voluptate velit esse cillum dolore eu fugiat nulla
										pariatur. Excepteur sint occaecat cupidatat non proident, sunt
										in culpa qui officia deserunt mollit anim id est laborum.</div>
								</div>
							</div>
						</div>
					</div>
					<!-- .panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</tiles:putAttribute>
</tiles:insertDefinition>