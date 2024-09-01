
import './NavigationStripe.css'

const NavigationStripe = () => {
    return (<div className="app-nav">
                
                <div className="app-nav-options">
                    <a href="/"> Home</a>
                    <a href="/search"> Search</a>
                    <a href="/add">Add new </a>
                </div>
                <div className="app-nav-delimiter"></div>
        </div>);

}


export default NavigationStripe;