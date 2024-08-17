import React, { useContext } from "react"
import MainHeader from "../layout/MainHeader"
import EventService from "../common/EventService"
import Parallax from "../common/Parallax"
import EventCarousel from "../common/EventCarousel"
import EventSearch from "../common/EventSearch"
import { useLocation } from "react-router-dom"
import { useAuth } from "../auth/AuthProvider"
const Home = () => {
	const location = useLocation()

	const message = location.state && location.state.message
	const currentUser = localStorage.getItem("userId")
	return (
		<section>
			{message && <p className="text-warning px-5">{message}</p>}
			{currentUser && (
				<h6 className="text-success text-center"> You are logged-In as {currentUser}</h6>
			)}
			<MainHeader />
			<div className="container">
				<EventSearch />
				<EventCarousel />
				<Parallax />
				<EventCarousel />
				<EventService />
				<Parallax />
				<EventCarousel />
			</div>
		</section>
	)
}

export default Home
