
import './SearchCommit.css';


const SearchComit = () => {
    return(
        <div className="app-search">
            <input className="app-search-input" type="text" value="Enter search term"></input>
            <button className="app-search-button"   type="submit"> Search</button>
            <div className="app-search-hr"><hr /></div>
        </div>
    );
    
}


export default SearchComit;