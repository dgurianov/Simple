import './App.css';
import ListOfCommits from './list-commits/ListOfCommits';
import NewCommitSection from './new-commit/NewCommitSection';
import SearchComit from './search-commit/SearchCommit';

function App() {
  return (
    <div className='app-container'>
      <div className='app-logo'>logo</div>
      <div className='app-break'></div>
      <SearchComit/>
      <div className='app-tags'>TAGS</div>
      <NewCommitSection/>
      
      <div className='app-list'><ListOfCommits/></div>
    
    </div>
  );
}

export default App;
