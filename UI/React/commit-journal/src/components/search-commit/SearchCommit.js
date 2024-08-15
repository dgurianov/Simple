
import './SearchCommit.css';



 const clickSearch = () => {
    console.log("Searching...");

 }

const SearchCommit = () => {
    return(
        <div className="app-search">
            <input className="app-search-input" type="text" value="Enter search term"></input>
            <button className="app-search-button"  onClick={clickSearch} type="submit"> Search</button>
            <div className="app-search-hr"><hr /></div>
        </div>
    );
    
}


export default SearchCommit;