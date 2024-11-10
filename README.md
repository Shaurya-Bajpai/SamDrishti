SamDrishti: Where Citizen meets Transperency


Problem Statement
Despite various efforts, there remains a significant gap between government actions and citizen needs. Citizens often lack accessible channels for expressing their concerns or sharing opinions on public services. Simultaneously, governments struggle to monitor public facilities, address grievances, and assess public sentiment in real time. This disconnect hinders effective governance and limits the government’s ability to prioritize actions based on real-time data.

How might we create a platform that enables citizens to communicate their concerns effectively and allows governments to prioritize actions based on real-time data and sentiment analysis?

Solution
SamDrishti is an AI-driven platform designed to improve citizen engagement and transparency in public grievance handling. It allows citizens to submit complaints (related to water, electricity, sanitation, etc.), provide feedback on government services, and access critical policy updates. For government officials, SamDrishti provides real-time analytics on public sentiment, monitors infrastructure issues, and facilitates better decision-making.

Key Features
Citizen Chatbot for Complaints and Queries

Citizens can use an intuitive chatbot to report issues and ask questions across sectors such as electricity, water, and sanitation. The chatbot routes each complaint to the relevant government department, reducing delays and enhancing accessibility.
Sentiment Analysis for Public Feedback

By analyzing public sentiment, SamDrishti enables government officials to gauge the public’s mood on policies or services. This data-driven approach allows officials to make informed, timely adjustments based on citizens’ needs and opinions.
Legal Document Summarizer

SamDrishti’s summarizer condenses complex legal documents into easy-to-read summaries, helping citizens and officials quickly understand policies and regulations.
Health Guidance for Humans and Animals

This feature offers preliminary health advice for common human and animal ailments, supporting underserved communities with basic health information.
Feedback System for Government Policies

Citizens can provide feedback on government policies directly through the platform. This feature allows officials to monitor public reaction to policies and make data-driven adjustments, strengthening the relationship between government and citizens.
Government Monitoring Dashboard

Government officials have access to a centralized dashboard where they can monitor complaints, feedback, and sentiment analysis in real time, ensuring a quicker response to public issues.
Technology Stack
Frontend: Kotlin (for Android UI)
Backend: Flask (Python)
Database: MongoDB
AI/ML: Python (NLTK, Pandas, Scikit-learn)
APIs: Twitter API, News API
Challenges We Faced
AI and Database Integration

Integrating AI features, such as sentiment analysis and the chatbot, posed challenges, especially in database synchronization for seamless citizen interaction. We optimized the data structure and streamlined database communication with MongoDB to resolve these issues.
Chatbot Development

Developing a functional chatbot involved ensuring efficient MongoDB integration and accurate query handling. We overcame this by refining the chatbot’s architecture and testing it with various scenarios to improve response accuracy.
Data Sourcing for Machine Learning Models

Finding suitable datasets for training our models was challenging. Through extensive research, we selected and adapted datasets that best matched our application needs.
Complex Feature Management

The app’s multifaceted nature made development complex. We addressed this by breaking tasks into smaller milestones and performing systematic testing, which helped us integrate features cohesively and maintain high functionality.
How SamDrishti Solves the Problem
SamDrishti provides a robust, AI-powered platform that enhances governance by:

Simplifying Communication: The chatbot enables easy, direct complaint submission, giving citizens a clear path to voice their concerns.
Increasing Transparency: The legal document summarizer and feedback systems allow citizens to understand and respond to policies, fostering an open, participatory environment.
Enabling Real-Time Data-Driven Decisions: With sentiment analysis and a government dashboard, officials gain actionable insights into public sentiment, helping them prioritize and address grievances based on data.
Supporting Public Health: The health guidance feature offers preliminary advice for both human and animal health, helping citizens in areas with limited healthcare access.
Through these solutions, SamDrishti aims to create a more transparent, responsive, and effective governance model, ultimately strengthening the relationship between the government and its citizens.

Future Scope
Enhanced Data Collection: Integrating real-time data from weather, traffic, and health APIs to enhance the chatbot's contextual awareness.
Improved AI Features: Expanding sentiment analysis to cover multiple languages for broader accessibility.
Citizen Engagement Programs: Adding gamification elements to encourage greater citizen participation and feedback.
Installation and Setup
Clone the Repository:

bash
Copy code
git clone https://github.com/yourusername/samdrishti.git
cd samdrishti
Backend Setup (Flask):

Install required Python packages:
bash
Copy code
pip install -r requirements.txt
Start the Flask backend:
bash
Copy code
python app.py
Database Setup (MongoDB):

Ensure MongoDB is installed and running. Configure connection settings in the backend as needed.
Frontend Setup (Kotlin):

Open the Android project in Android Studio.
Build and run the app on an emulator or a physical device.
Access the Dashboard:
The backend runs on http://localhost:5000. Use this endpoint to connect the Kotlin UI with the Flask backend.

Contact
For more information or to contribute to this project, please reach out to shuklashivansh343@gmail.com.
